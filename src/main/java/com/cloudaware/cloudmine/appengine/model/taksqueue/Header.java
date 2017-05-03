package com.cloudaware.cloudmine.appengine.model.taksqueue;

import java.util.List;

public final class Header {
    private String headerName;
    private List<String> headerValues;

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(final String headerName) {
        this.headerName = headerName;
    }

    public List<String> getHeaderValues() {
        return headerValues;
    }

    public void setHeaderValues(final List<String> headerValues) {
        this.headerValues = headerValues;
    }
}
