package com.cloudaware.cloudmine.appengine.model.taksqueue;

public final class Param {
    private String name;
    private String stringValue;
    private byte[] byteArrayValue;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(final String stringValue) {
        this.stringValue = stringValue;
    }

    public byte[] getByteArrayValue() {
        return byteArrayValue;
    }

    public void setByteArrayValue(final byte[] byteArrayValue) {
        this.byteArrayValue = byteArrayValue;
    }
}
