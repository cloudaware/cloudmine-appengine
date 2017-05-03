package com.cloudaware.cloudmine.appengine.model.taksqueue;

import java.util.List;

public final class TaskOptions {
    private String taskName;
    private String payload;
    private byte[] payloadBytes;
    private List<Header> headers;
    private com.google.appengine.api.taskqueue.TaskOptions.Method method;
    private List<Param> params;
    private String url;
    private Long countdownMillis;
    private Long etaMillis;
    private RetryOptions retryOptions;
    private String tag;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(final String taskName) {
        this.taskName = taskName;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(final String payload) {
        this.payload = payload;
    }

    public byte[] getPayloadBytes() {
        return payloadBytes;
    }

    public void setPayloadBytes(final byte[] payloadBytes) {
        this.payloadBytes = payloadBytes;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(final List<Header> headers) {
        this.headers = headers;
    }

    public com.google.appengine.api.taskqueue.TaskOptions.Method getMethod() {
        return method;
    }

    public void setMethod(final com.google.appengine.api.taskqueue.TaskOptions.Method method) {
        this.method = method;
    }

    public List<Param> getParams() {
        return params;
    }

    public void setParams(final List<Param> params) {
        this.params = params;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public Long getCountdownMillis() {
        return countdownMillis;
    }

    public void setCountdownMillis(final Long countdownMillis) {
        this.countdownMillis = countdownMillis;
    }

    public Long getEtaMillis() {
        return etaMillis;
    }

    public void setEtaMillis(final Long etaMillis) {
        this.etaMillis = etaMillis;
    }

    public RetryOptions getRetryOptions() {
        return retryOptions;
    }

    public void setRetryOptions(final RetryOptions retryOptions) {
        this.retryOptions = retryOptions;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(final String tag) {
        this.tag = tag;
    }
}
