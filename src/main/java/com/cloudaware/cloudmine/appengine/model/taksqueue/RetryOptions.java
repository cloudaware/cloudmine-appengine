package com.cloudaware.cloudmine.appengine.model.taksqueue;

public final class RetryOptions {
    private Integer taskRetryLimit;
    private Long taskAgeLimitSeconds;
    private Double minBackoffSeconds;
    private Double maxBackoffSeconds;
    private Integer maxDoublings;

    public Integer getTaskRetryLimit() {
        return taskRetryLimit;
    }

    public void setTaskRetryLimit(final Integer taskRetryLimit) {
        this.taskRetryLimit = taskRetryLimit;
    }

    public Long getTaskAgeLimitSeconds() {
        return taskAgeLimitSeconds;
    }

    public void setTaskAgeLimitSeconds(final Long taskAgeLimitSeconds) {
        this.taskAgeLimitSeconds = taskAgeLimitSeconds;
    }

    public Double getMinBackoffSeconds() {
        return minBackoffSeconds;
    }

    public void setMinBackoffSeconds(final Double minBackoffSeconds) {
        this.minBackoffSeconds = minBackoffSeconds;
    }

    public Double getMaxBackoffSeconds() {
        return maxBackoffSeconds;
    }

    public void setMaxBackoffSeconds(final Double maxBackoffSeconds) {
        this.maxBackoffSeconds = maxBackoffSeconds;
    }

    public Integer getMaxDoublings() {
        return maxDoublings;
    }

    public void setMaxDoublings(final Integer maxDoublings) {
        this.maxDoublings = maxDoublings;
    }
}
