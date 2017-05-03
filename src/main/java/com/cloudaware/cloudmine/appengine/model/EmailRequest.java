package com.cloudaware.cloudmine.appengine.model;

import java.util.List;

public final class EmailRequest {
    private EmailAddress fromAddress;
    private List<EmailAddress> toAddresses;
    private List<EmailAddress> ccAddresses;
    private List<EmailAddress> bccAddresses;
    private String subject;
    private String content;
    private String contentEncoding;

    public EmailAddress getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(final EmailAddress fromAddress) {
        this.fromAddress = fromAddress;
    }

    public List<EmailAddress> getToAddresses() {
        return toAddresses;
    }

    public void setToAddresses(final List<EmailAddress> toAddresses) {
        this.toAddresses = toAddresses;
    }

    public List<EmailAddress> getCcAddresses() {
        return ccAddresses;
    }

    public void setCcAddresses(final List<EmailAddress> ccAddresses) {
        this.ccAddresses = ccAddresses;
    }

    public List<EmailAddress> getBccAddresses() {
        return bccAddresses;
    }

    public void setBccAddresses(final List<EmailAddress> bccAddresses) {
        this.bccAddresses = bccAddresses;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public String getContentEncoding() {
        return contentEncoding;
    }

    public void setContentEncoding(final String contentEncoding) {
        this.contentEncoding = contentEncoding;
    }
}
