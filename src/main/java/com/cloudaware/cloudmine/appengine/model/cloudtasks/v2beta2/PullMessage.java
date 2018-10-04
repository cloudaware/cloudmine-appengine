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
 * The pull message contains data that can be used by the caller of CloudTasks.PullTasks to process
 * the task.
 * <p>
 * This proto can only be used for tasks in a queue which has Queue.pull_target set.
 * <p>
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the Cloud Tasks API. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class PullMessage {

    /**
     * A data payload consumed by the task worker to execute the task.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String payload;

    /**
     * A meta-data tag for this task.
     * <p>
     * This value is used by CloudTasks.PullTasks calls when PullTasksRequest.filter is `tag=`.
     * <p>
     * The tag must be less than 500 bytes.
     * The value may be {@code null}.
     */
    @com.google.api.client.util.Key
    private String tag;

    /**
     * A data payload consumed by the task worker to execute the task.
     *
     * @return value or {@code null} for none
     * @see #decodePayload()
     */
    public String getPayload() {
        return payload;
    }

    /**
     * A data payload consumed by the task worker to execute the task.
     *
     * @param payload payload or {@code null} for none
     * @see #encodePayload()
     */
    public PullMessage setPayload(String payload) {
        this.payload = payload;
        return this;
    }

    /**
     * A data payload consumed by the task worker to execute the task.
     *
     * @return Base64 decoded value or {@code null} for none
     * @see #getPayload()
     * @since 1.14
     */
    public byte[] decodePayload() {
        return com.google.api.client.util.Base64.decodeBase64(payload);
    }

    /**
     * A data payload consumed by the task worker to execute the task.
     *
     * @see #setPayload()
     * <p>
     * <p>
     * The value is encoded Base64 or {@code null} for none.
     * </p>
     * @since 1.14
     */
    public PullMessage encodePayload(byte[] payload) {
        this.payload = com.google.api.client.util.Base64.encodeBase64URLSafeString(payload);
        return this;
    }

    /**
     * A meta-data tag for this task.
     * <p>
     * This value is used by CloudTasks.PullTasks calls when PullTasksRequest.filter is `tag=`.
     * <p>
     * The tag must be less than 500 bytes.
     *
     * @return value or {@code null} for none
     * @see #decodeTag()
     */
    public String getTag() {
        return tag;
    }

    /**
     * A meta-data tag for this task.
     * <p>
     * This value is used by CloudTasks.PullTasks calls when PullTasksRequest.filter is `tag=`.
     * <p>
     * The tag must be less than 500 bytes.
     *
     * @param tag tag or {@code null} for none
     * @see #encodeTag()
     */
    public PullMessage setTag(String tag) {
        this.tag = tag;
        return this;
    }

    /**
     * A meta-data tag for this task.
     * <p>
     * This value is used by CloudTasks.PullTasks calls when PullTasksRequest.filter is `tag=`.
     * <p>
     * The tag must be less than 500 bytes.
     *
     * @return Base64 decoded value or {@code null} for none
     * @see #getTag()
     * @since 1.14
     */
    public byte[] decodeTag() {
        return com.google.api.client.util.Base64.decodeBase64(tag);
    }

    /**
     * A meta-data tag for this task.
     * <p>
     * This value is used by CloudTasks.PullTasks calls when PullTasksRequest.filter is `tag=`.
     * <p>
     * The tag must be less than 500 bytes.
     *
     * @see #setTag()
     * <p>
     * <p>
     * The value is encoded Base64 or {@code null} for none.
     * </p>
     * @since 1.14
     */
    public PullMessage encodeTag(byte[] tag) {
        this.tag = com.google.api.client.util.Base64.encodeBase64URLSafeString(tag);
        return this;
    }

}