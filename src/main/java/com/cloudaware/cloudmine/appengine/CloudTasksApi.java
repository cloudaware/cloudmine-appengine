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

import com.cloudaware.cloudmine.appengine.model.cloudtasks.AppEngineTaskTarget;
import com.cloudaware.cloudmine.appengine.model.cloudtasks.CreateTaskRequest;
import com.cloudaware.cloudmine.appengine.model.cloudtasks.RetryConfig;
import com.cloudaware.cloudmine.appengine.model.cloudtasks.Task;
import com.google.api.server.spi.Constant;
import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.InternalServerErrorException;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskAlreadyExistsException;

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
        version = "v2beta2",
        scopes = {Constant.API_EMAIL_SCOPE},
        clientIds = {Constant.API_EXPLORER_CLIENT_ID},
        apiKeyRequired = AnnotationBoolean.TRUE
)
public final class CloudTasksApi {

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
    ) throws InternalServerErrorException, ConflictException {
        if (projectId == null || locationId == null || queueName == null) {
            throw new InternalServerErrorException("Cannot find parent");
        }

        final com.google.appengine.api.taskqueue.TaskOptions in = com.google.appengine.api.taskqueue.TaskOptions.Builder.withDefaults();
        final Task task = createTaskRequest.getTask();

        if (task.getScheduleTime() != null) {
            //TODO: extract from iso date, and set difference to countdown
//            in.countdownMillis(taskOptions.getCountdownMillis());
        }
//        if (taskOptions.getEtaMillis() != null) {
//            in.etaMillis(taskOptions.getEtaMillis());
//        }

        final AppEngineTaskTarget appEngineTaskTarget = task.getAppEngineTaskTarget();

        if (appEngineTaskTarget.getHeaders() != null) {
            for (final String header : appEngineTaskTarget.getHeaders().keySet()) {
                in.header(header, appEngineTaskTarget.getHeaders().get(header));
            }
        }
        if (appEngineTaskTarget.getHttpMethod() != null) {
            in.method(com.google.appengine.api.taskqueue.TaskOptions.Method.valueOf(appEngineTaskTarget.getHttpMethod()));
        }

        if (appEngineTaskTarget.getPayload() != null) {
            in.payload(com.google.api.client.util.Base64.decodeBase64(appEngineTaskTarget.getPayload()));
        }
//        if (taskOptions.getPayloadBytes() != null) {
//            in.payload(taskOptions.getPayloadBytes());
//        }

        if (appEngineTaskTarget.getRetryConfig() != null) {
            final com.google.appengine.api.taskqueue.RetryOptions rt = com.google.appengine.api.taskqueue.RetryOptions.Builder.withDefaults();
            final RetryConfig retryConfig = appEngineTaskTarget.getRetryConfig();
            if (retryConfig.getMaxBackoff() != null) {
                rt.maxBackoffSeconds(Double.parseDouble(
                        retryConfig.getMaxBackoff().substring(0, retryConfig.getMaxBackoff().length() - 1)
                ));
            }
            if (retryConfig.getMaxDoublings() != null) {
                rt.maxDoublings(retryConfig.getMaxDoublings());
            }
            if (retryConfig.getMinBackoff() != null) {
                rt.minBackoffSeconds(Double.parseDouble(
                        retryConfig.getMinBackoff().substring(0, retryConfig.getMinBackoff().length() - 1)
                ));
            }
            if (retryConfig.getTaskAgeLimit() != null) {
                rt.taskAgeLimitSeconds(Long.parseLong(
                        retryConfig.getTaskAgeLimit().substring(0, retryConfig.getTaskAgeLimit().length() - 1)
                ));
            }
            if ((retryConfig.getUnlimitedAttempts() == null || !retryConfig.getUnlimitedAttempts()) && retryConfig.getMaxAttempts() != null) {
                rt.taskRetryLimit(retryConfig.getMaxAttempts());
            }
            in.retryOptions(rt);
        }
//        if (taskOptions.getTag() != null) {
//            in.tag(taskOptions.getTag());
//        }
        if (task.getName() != null) {
            String taskName = task.getName();
            final int index = taskName.indexOf("/tasks/");
            if (index != -1) {
                taskName = taskName.substring(index + 7);
            }
            in.taskName(taskName);
        }
        if (appEngineTaskTarget.getRelativeUrl() != null) {
            final String[] parts = appEngineTaskTarget.getRelativeUrl().split("\\?");
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
        out.setAppEngineTaskTarget(task.getAppEngineTaskTarget());
        out.setName(taskHandle.getName());
        return out;
    }
}
