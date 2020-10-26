package com.atm.utils;

public class ResponseMessage {

    public static final String SUCCESS = "Success";
    public static final String INFO = "Info";
    public static final String ERROR = "Error";

    private String severity;
    private String detail;
    private Object responseObject;

    public ResponseMessage(String severity, String detail) {
        this.severity = severity;
        this.detail = detail;
    }

    public ResponseMessage(String severity, String detail, Object responseObject) {
        this.severity = severity;
        this.detail = detail;
        this.responseObject = responseObject;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }
}
