package com.cloudaware.cloudmine.appengine.model.cloudtasks.v2;

/**
 * Request message for CreateTask.
 *
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
     * By default response_view is BASIC; not all information is retrieved by default because some
     * data, such as payloads, might be desirable to return only when needed because of its large size
     * or because of the sensitivity of data that it contains.
     * <p>
     * Authorization for FULL requires `cloudtasks.tasks.fullView` [Google
     * IAM](https://cloud.google.com/iam/) permission on the Task resource.
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
     * optionally specify a task name. If a name is not specified then the system will generate a
     * random unique task id, which will be set in the task returned in the response.
     * <p>
     * If schedule_time is not set or is in the past then Cloud Tasks will set it to the current time.
     * <p>
     * Task De-duplication:
     * <p>
     * Explicitly specifying a task ID enables task de-duplication.  If a task's ID is identical to
     * that of an existing task or a task that was deleted or executed recently then the call will
     * fail with ALREADY_EXISTS. If the task's queue was created using Cloud Tasks, then another task
     * with the same name can't be created for ~1hour after the original task was deleted or executed.
     * If the task's queue was created using queue.yaml or queue.xml, then another task with the same
     * name can't be created for ~9days after the original task was deleted or executed.
     * <p>
     * Because there is an extra lookup cost to identify duplicate task names, these CreateTask calls
     * have significantly increased latency. Using hashed strings for the task id or for the prefix of
     * the task id is recommended. Choosing task ids that are sequential or have sequential prefixes,
     * for example using a timestamp, causes an increase in latency and error rates in all task
     * commands. The infrastructure relies on an approximately uniform distribution of task ids to
     * store and serve tasks efficiently.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private Task task;

    /**
     * The response_view specifies which subset of the Task will be returned.
     * <p>
     * By default response_view is BASIC; not all information is retrieved by default because some
     * data, such as payloads, might be desirable to return only when needed because of its large size
     * or because of the sensitivity of data that it contains.
     * <p>
     * Authorization for FULL requires `cloudtasks.tasks.fullView` [Google
     * IAM](https://cloud.google.com/iam/) permission on the Task resource.
     *
     * @return value or {@code null} for none
     */
    public String getResponseView() {
        return responseView;
    }

    /**
     * The response_view specifies which subset of the Task will be returned.
     * <p>
     * By default response_view is BASIC; not all information is retrieved by default because some
     * data, such as payloads, might be desirable to return only when needed because of its large size
     * or because of the sensitivity of data that it contains.
     * <p>
     * Authorization for FULL requires `cloudtasks.tasks.fullView` [Google
     * IAM](https://cloud.google.com/iam/) permission on the Task resource.
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
     * optionally specify a task name. If a name is not specified then the system will generate a
     * random unique task id, which will be set in the task returned in the response.
     * <p>
     * If schedule_time is not set or is in the past then Cloud Tasks will set it to the current time.
     * <p>
     * Task De-duplication:
     * <p>
     * Explicitly specifying a task ID enables task de-duplication.  If a task's ID is identical to
     * that of an existing task or a task that was deleted or executed recently then the call will
     * fail with ALREADY_EXISTS. If the task's queue was created using Cloud Tasks, then another task
     * with the same name can't be created for ~1hour after the original task was deleted or executed.
     * If the task's queue was created using queue.yaml or queue.xml, then another task with the same
     * name can't be created for ~9days after the original task was deleted or executed.
     * <p>
     * Because there is an extra lookup cost to identify duplicate task names, these CreateTask calls
     * have significantly increased latency. Using hashed strings for the task id or for the prefix of
     * the task id is recommended. Choosing task ids that are sequential or have sequential prefixes,
     * for example using a timestamp, causes an increase in latency and error rates in all task
     * commands. The infrastructure relies on an approximately uniform distribution of task ids to
     * store and serve tasks efficiently.
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
     * optionally specify a task name. If a name is not specified then the system will generate a
     * random unique task id, which will be set in the task returned in the response.
     * <p>
     * If schedule_time is not set or is in the past then Cloud Tasks will set it to the current time.
     * <p>
     * Task De-duplication:
     * <p>
     * Explicitly specifying a task ID enables task de-duplication.  If a task's ID is identical to
     * that of an existing task or a task that was deleted or executed recently then the call will
     * fail with ALREADY_EXISTS. If the task's queue was created using Cloud Tasks, then another task
     * with the same name can't be created for ~1hour after the original task was deleted or executed.
     * If the task's queue was created using queue.yaml or queue.xml, then another task with the same
     * name can't be created for ~9days after the original task was deleted or executed.
     * <p>
     * Because there is an extra lookup cost to identify duplicate task names, these CreateTask calls
     * have significantly increased latency. Using hashed strings for the task id or for the prefix of
     * the task id is recommended. Choosing task ids that are sequential or have sequential prefixes,
     * for example using a timestamp, causes an increase in latency and error rates in all task
     * commands. The infrastructure relies on an approximately uniform distribution of task ids to
     * store and serve tasks efficiently.
     *
     * @param task task or {@code null} for none
     */
    public CreateTaskRequest setTask(Task task) {
        this.task = task;
        return this;
    }

}

