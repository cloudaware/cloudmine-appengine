/*
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2017-09-26 19:19:48 UTC)
 * on 2017-10-23 at 22:53:17 UTC 
 * Modify at your own risk.
 */

package com.cloudaware.cloudmine.appengine.model.cloudtasks.v2beta2;

/**
 * Request message for CloudTasks.CreateTask.
 * <p>
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the Cloud Tasks API. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class CreateTaskRequest {

    /**
     * The response_view specifies which subset of the Task will be returned.
     * <p>
     * By default response_view is Task.View.BASIC; not all information is retrieved by default
     * because some data, such as payloads, might be desirable to return only when needed because of
     * its large size or because of the sensitivity of data that it contains.
     * <p>
     * Authorization for Task.View.FULL requires `cloudtasks.tasks.fullView` [Google IAM](/iam/)
     * permission on the Task.name resource.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String responseView;

    /**
     * Required.
     * <p>
     * The task to add.
     * <p>
     * Task names have the following format:
     * `projects/PROJECT_ID/locations/LOCATION_ID/queues/QUEUE_ID/tasks/TASK_ID`. The user can
     * optionally specify a name for the task in Task.name. If a name is not specified then the system
     * will generate a random unique task id, which will be returned in the response's Task.name.
     * <p>
     * If Task.schedule_time is not set or is in the past then Cloud Tasks will set it to the current
     * time.
     * <p>
     * Task De-duplication:
     * <p>
     * Explicitly specifying a task ID enables task de-duplication.  If a task's ID is identical to
     * that of an existing task or a task that was deleted or completed recently then the call will
     * fail with google.rpc.Code.ALREADY_EXISTS. If the task's queue was created using Cloud Tasks,
     * then another task with the same name can't be created for ~1hour after the original task was
     * deleted or completed. If the task's queue was created using queue.yaml or queue.xml, then
     * another task with the same name can't be created for ~9days after the original task was deleted
     * or completed.
     * <p>
     * Because there is an extra lookup cost to identify duplicate task names, these
     * CloudTasks.CreateTask calls have significantly increased latency. Using hashed strings for the
     * task id or for the prefix of the task id is recommended. Choosing task ids that are sequential
     * or have sequential prefixes, for example using a timestamp, causes an increase in latency and
     * error rates in all task commands. The infrastructure relies on an approximately uniform
     * distribution of task ids to store and serve tasks efficiently.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private Task task;

    /**
     * The response_view specifies which subset of the Task will be returned.
     * <p>
     * By default response_view is Task.View.BASIC; not all information is retrieved by default
     * because some data, such as payloads, might be desirable to return only when needed because of
     * its large size or because of the sensitivity of data that it contains.
     * <p>
     * Authorization for Task.View.FULL requires `cloudtasks.tasks.fullView` [Google IAM](/iam/)
     * permission on the Task.name resource.
     *
     * @return value or {@code null} for none
     */
    public String getResponseView() {
        return responseView;
    }

    /**
     * The response_view specifies which subset of the Task will be returned.
     * <p>
     * By default response_view is Task.View.BASIC; not all information is retrieved by default
     * because some data, such as payloads, might be desirable to return only when needed because of
     * its large size or because of the sensitivity of data that it contains.
     * <p>
     * Authorization for Task.View.FULL requires `cloudtasks.tasks.fullView` [Google IAM](/iam/)
     * permission on the Task.name resource.
     *
     * @param responseView responseView or {@code null} for none
     */
    public CreateTaskRequest setResponseView(String responseView) {
        this.responseView = responseView;
        return this;
    }

    /**
     * Required.
     * <p>
     * The task to add.
     * <p>
     * Task names have the following format:
     * `projects/PROJECT_ID/locations/LOCATION_ID/queues/QUEUE_ID/tasks/TASK_ID`. The user can
     * optionally specify a name for the task in Task.name. If a name is not specified then the system
     * will generate a random unique task id, which will be returned in the response's Task.name.
     * <p>
     * If Task.schedule_time is not set or is in the past then Cloud Tasks will set it to the current
     * time.
     * <p>
     * Task De-duplication:
     * <p>
     * Explicitly specifying a task ID enables task de-duplication.  If a task's ID is identical to
     * that of an existing task or a task that was deleted or completed recently then the call will
     * fail with google.rpc.Code.ALREADY_EXISTS. If the task's queue was created using Cloud Tasks,
     * then another task with the same name can't be created for ~1hour after the original task was
     * deleted or completed. If the task's queue was created using queue.yaml or queue.xml, then
     * another task with the same name can't be created for ~9days after the original task was deleted
     * or completed.
     * <p>
     * Because there is an extra lookup cost to identify duplicate task names, these
     * CloudTasks.CreateTask calls have significantly increased latency. Using hashed strings for the
     * task id or for the prefix of the task id is recommended. Choosing task ids that are sequential
     * or have sequential prefixes, for example using a timestamp, causes an increase in latency and
     * error rates in all task commands. The infrastructure relies on an approximately uniform
     * distribution of task ids to store and serve tasks efficiently.
     *
     * @return value or {@code null} for none
     */
    public Task getTask() {
        return task;
    }

    /**
     * Required.
     * <p>
     * The task to add.
     * <p>
     * Task names have the following format:
     * `projects/PROJECT_ID/locations/LOCATION_ID/queues/QUEUE_ID/tasks/TASK_ID`. The user can
     * optionally specify a name for the task in Task.name. If a name is not specified then the system
     * will generate a random unique task id, which will be returned in the response's Task.name.
     * <p>
     * If Task.schedule_time is not set or is in the past then Cloud Tasks will set it to the current
     * time.
     * <p>
     * Task De-duplication:
     * <p>
     * Explicitly specifying a task ID enables task de-duplication.  If a task's ID is identical to
     * that of an existing task or a task that was deleted or completed recently then the call will
     * fail with google.rpc.Code.ALREADY_EXISTS. If the task's queue was created using Cloud Tasks,
     * then another task with the same name can't be created for ~1hour after the original task was
     * deleted or completed. If the task's queue was created using queue.yaml or queue.xml, then
     * another task with the same name can't be created for ~9days after the original task was deleted
     * or completed.
     * <p>
     * Because there is an extra lookup cost to identify duplicate task names, these
     * CloudTasks.CreateTask calls have significantly increased latency. Using hashed strings for the
     * task id or for the prefix of the task id is recommended. Choosing task ids that are sequential
     * or have sequential prefixes, for example using a timestamp, causes an increase in latency and
     * error rates in all task commands. The infrastructure relies on an approximately uniform
     * distribution of task ids to store and serve tasks efficiently.
     *
     * @param task task or {@code null} for none
     */
    public CreateTaskRequest setTask(Task task) {
        this.task = task;
        return this;
    }

}