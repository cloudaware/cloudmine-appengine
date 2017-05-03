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

import com.cloudaware.cloudmine.appengine.model.EmailAddress;
import com.cloudaware.cloudmine.appengine.model.EmailRequest;
import com.cloudaware.cloudmine.appengine.model.taksqueue.Header;
import com.cloudaware.cloudmine.appengine.model.taksqueue.Param;
import com.cloudaware.cloudmine.appengine.model.taksqueue.TaskHandle;
import com.cloudaware.cloudmine.appengine.model.taksqueue.TaskOptions;
import com.google.api.server.spi.Constant;
import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.common.base.Strings;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Api(
        name = "appengine",
        canonicalName = "AppEngine",
        title = "App Engine",
        description = "Proxy for services available in AppEngine Standard",
        namespace = @ApiNamespace(
                ownerDomain = "cloudaware.com",
                ownerName = "CloudAware",
                packagePath = "cloudmine"
        ),
        version = "v1",
        scopes = {Constant.API_EMAIL_SCOPE},
        clientIds = {Constant.API_EXPLORER_CLIENT_ID},
        apiKeyRequired = AnnotationBoolean.TRUE
)
public final class AppEngineApi {

    public static final int ADMIN_EMAIL_MAX_SIZE = 15 * 1024;

    private static InternetAddress convert(final EmailAddress emailAddress) throws AddressException, UnsupportedEncodingException {
        if (Strings.isNullOrEmpty(emailAddress.getName())) {
            return new InternetAddress(emailAddress.getEmail());
        } else {
            return new InternetAddress(emailAddress.getEmail(), emailAddress.getName());
        }
    }

    @ApiMethod(
            httpMethod = ApiMethod.HttpMethod.POST,
            name = "queues.tasks.add",
            path = "queues/{queueName}/tasks"
    )
    public TaskHandle queuesTasksAdd(
            @Named("queueName") final String queueName,
            final TaskOptions taskOptions
    ) {
        final com.google.appengine.api.taskqueue.TaskOptions in = com.google.appengine.api.taskqueue.TaskOptions.Builder.withDefaults();
        if (taskOptions.getCountdownMillis() != null) {
            in.countdownMillis(taskOptions.getCountdownMillis());
        }
        if (taskOptions.getEtaMillis() != null) {
            in.etaMillis(taskOptions.getEtaMillis());
        }
        if (taskOptions.getHeaders() != null) {
            for (final Header header : taskOptions.getHeaders()) {
                if (header.getHeaderValues() != null) {
                    for (final String value : header.getHeaderValues()) {
                        in.header(header.getHeaderName(), value);
                    }
                }
            }
        }
        if (taskOptions.getMethod() != null) {
            in.method(taskOptions.getMethod());
        }
        if (taskOptions.getParams() != null) {
            for (final Param param : taskOptions.getParams()) {
                if (param.getStringValue() != null) {
                    in.param(param.getName(), param.getStringValue());
                } else if (param.getByteArrayValue() != null) {
                    in.param(param.getName(), param.getByteArrayValue());
                } else {
                    throw new IllegalArgumentException("param ('" + param.getName() + "') value can't be null");
                }
            }
        }
        if (taskOptions.getPayload() != null) {
            in.payload(taskOptions.getPayload());
        }
        if (taskOptions.getPayloadBytes() != null) {
            in.payload(taskOptions.getPayloadBytes());
        }
        if (taskOptions.getRetryOptions() != null) {
            final com.google.appengine.api.taskqueue.RetryOptions rt = com.google.appengine.api.taskqueue.RetryOptions.Builder.withDefaults();
            if (taskOptions.getRetryOptions().getMaxBackoffSeconds() != null) {
                rt.maxBackoffSeconds(taskOptions.getRetryOptions().getMaxBackoffSeconds());
            }
            if (taskOptions.getRetryOptions().getMaxDoublings() != null) {
                rt.maxDoublings(taskOptions.getRetryOptions().getMaxDoublings());
            }
            if (taskOptions.getRetryOptions().getMinBackoffSeconds() != null) {
                rt.minBackoffSeconds(taskOptions.getRetryOptions().getMinBackoffSeconds());
            }
            if (taskOptions.getRetryOptions().getTaskAgeLimitSeconds() != null) {
                rt.taskAgeLimitSeconds(taskOptions.getRetryOptions().getTaskAgeLimitSeconds());
            }
            if (taskOptions.getRetryOptions().getTaskRetryLimit() != null) {
                rt.taskRetryLimit(taskOptions.getRetryOptions().getTaskRetryLimit());
            }
            in.retryOptions(rt);
        }
        if (taskOptions.getTag() != null) {
            in.tag(taskOptions.getTag());
        }
        if (taskOptions.getTaskName() != null) {
            in.taskName(taskOptions.getTaskName());
        }
        if (taskOptions.getUrl() != null) {
            in.url(taskOptions.getUrl());
        }
        final com.google.appengine.api.taskqueue.TaskHandle out = QueueFactory.getQueue(queueName).add(in);
        final TaskHandle response = new TaskHandle();
        response.setTaskName(out.getName());
        response.setQueueName(out.getQueueName());
        response.setEtaMillis(out.getEtaMillis());
        response.setRetryCount(out.getRetryCount());
        return response;
    }

    @ApiMethod(
            httpMethod = ApiMethod.HttpMethod.POST,
            name = "emails.send",
            path = "emails"
    )
    public void emailsSend(final EmailRequest emailRequest) throws UnsupportedEncodingException, MessagingException {
        if (emailRequest.getFromAddress() == null) {
            throw new IllegalArgumentException("fromAddress can't be empty");
        }
        final Properties props = new Properties();
        final Session session = Session.getDefaultInstance(props, null);
        final Message msg = new MimeMessage(session);
        msg.setFrom(convert(emailRequest.getFromAddress()));
        boolean toAdmins = false;
        if (emailRequest.getToAddresses() != null) {
            for (final EmailAddress emailAddress : emailRequest.getToAddresses()) {
                if ("admins".equals(emailAddress.getEmail())) {
                    toAdmins = true;
                }
                msg.addRecipient(Message.RecipientType.TO, convert(emailAddress));
            }
        }
        if (emailRequest.getCcAddresses() != null) {
            for (final EmailAddress emailAddress : emailRequest.getCcAddresses()) {
                if ("admins".equals(emailAddress.getEmail())) {
                    toAdmins = true;
                }
                msg.addRecipient(Message.RecipientType.TO, convert(emailAddress));
            }
        }
        if (emailRequest.getBccAddresses() != null) {
            for (final EmailAddress emailAddress : emailRequest.getToAddresses()) {
                if ("admins".equals(emailAddress.getEmail())) {
                    toAdmins = true;
                }
                msg.addRecipient(Message.RecipientType.TO, convert(emailAddress));
            }
        }
        String content = emailRequest.getContent();
        if (toAdmins) {
            if (content.length() > ADMIN_EMAIL_MAX_SIZE) {
                // Лимит на размер письма админам 16к на body+headers+все остальное. Отрезаем по 15к, чтобы был запас
                content = content.substring(ADMIN_EMAIL_MAX_SIZE) + " (truncated. 16k limit)";
            }
        }
        msg.setSubject(emailRequest.getSubject());
        msg.setContent(content, emailRequest.getContentEncoding());
        Transport.send(msg);
    }
}
