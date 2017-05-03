package com.cloudaware.cloudmine.appengine.model.taksqueue;

public final class TaskHandle {
    private String taskName;
    private String queueName;
    private long etaMillis;
    private Integer retryCount;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(final String taskName) {
        this.taskName = taskName;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(final String queueName) {
        this.queueName = queueName;
    }

    public long getEtaMillis() {
        return etaMillis;
    }

    public void setEtaMillis(final long etaMillis) {
        this.etaMillis = etaMillis;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(final Integer retryCount) {
        this.retryCount = retryCount;
    }
}
