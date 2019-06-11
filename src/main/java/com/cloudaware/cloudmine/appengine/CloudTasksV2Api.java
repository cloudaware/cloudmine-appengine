/*
 * Copyright (c) 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not  use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.cloudaware.cloudmine.appengine;

import com.cloudaware.cloudmine.appengine.model.cloudtasks.v2.AppEngineHttpRequest;
import com.cloudaware.cloudmine.appengine.model.cloudtasks.v2.CreateTaskRequest;
import com.cloudaware.cloudmine.appengine.model.cloudtasks.v2.Task;
import com.google.api.server.spi.Constant;
import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.BadRequestException;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.InternalServerErrorException;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskAlreadyExistsException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Api(
        name = "cloudtasks",
        canonicalName = "CloudTasks",
        title = "Cloud Tasks",
        description = "Local implementation on Cloud Tasks API",
        namespace = @ApiNamespace(
                ownerDomain = "cloudaware.com",
                ownerName = "CloudAware",
                packagePath = "cloudmine"
        ),
        version = "v2",
        scopes = {Constant.API_EMAIL_SCOPE},
        clientIds = {Constant.API_EXPLORER_CLIENT_ID},
        apiKeyRequired = AnnotationBoolean.TRUE
)
public final class CloudTasksV2Api {

    @ApiMethod(
            httpMethod = ApiMethod.HttpMethod.POST,
            name = "queues.tasks.add",
            path = "projects/{projectId}/locations/{locationId}/queues/{queueName}/tasks"
    )
    public Task queuesTasksAdd(
            @Named("projectId") final String projectId,
            @Named("locationId") final String locationId,
            @Named("queueName") final String queueName,
            final CreateTaskRequest createTaskRequest
    ) throws InternalServerErrorException, ConflictException, BadRequestException {
        if (projectId == null || locationId == null || queueName == null) {
            throw new InternalServerErrorException("Cannot find parent");
        }

        final com.google.appengine.api.taskqueue.TaskOptions in = com.google.appengine.api.taskqueue.TaskOptions.Builder.withDefaults();
        final Task task = createTaskRequest.getTask();

        if (task.getName() != null) {
            String taskName = task.getName();
            final int index = taskName.indexOf("/tasks/");
            if (index != -1) {
                taskName = taskName.substring(index + 7);
            }
            in.taskName(taskName);
        }

        if (task.getScheduleTime() != null) {
            try {
                final Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").parse(task.getScheduleTime());
                in.etaMillis(date.getTime());
            } catch (ParseException e) {
                throw new InternalServerErrorException("Cannot deserialize Schedule Time");
            }
        }

        final AppEngineHttpRequest appEngineHttpRequest = task.getAppEngineHttpRequest();

        if (appEngineHttpRequest.getHeaders() != null) {
            for (final String header : appEngineHttpRequest.getHeaders().keySet()) {
                in.header(header, appEngineHttpRequest.getHeaders().get(header));
            }
        }
        if (appEngineHttpRequest.getHttpMethod() != null) {
            in.method(com.google.appengine.api.taskqueue.TaskOptions.Method.valueOf(appEngineHttpRequest.getHttpMethod()));
        }

        if (appEngineHttpRequest.getBody() != null) {
            in.payload(com.google.api.client.util.Base64.decodeBase64(appEngineHttpRequest.getBody()));
        }
        if (appEngineHttpRequest.getRelativeUri() != null) {
            final String[] parts = appEngineHttpRequest.getRelativeUri().split("\\?");
            in.url(parts[0]);
            if (parts.length > 1) {
                final String[] queryParams = parts[1].split("&");
                for (final String queryParam : queryParams) {
                    if (!"".equals(queryParam)) {
                        final String[] param = queryParam.split("=");
                        in.param(param[0], param[1]);
                    }
                }
            }
        }

        final com.google.appengine.api.taskqueue.TaskHandle taskHandle;
        try {
            taskHandle = QueueFactory.getQueue(queueName).add(in);
        } catch (TaskAlreadyExistsException e) {
            throw new ConflictException("Requested entity already exists", "alreadyExist", "global");
        }
        final Task out = new Task();
        out.setAppEngineHttpRequest(task.getAppEngineHttpRequest());
        out.setName(taskHandle.getName());
        return out;
    }
}
