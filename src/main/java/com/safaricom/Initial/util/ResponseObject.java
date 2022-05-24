package com.safaricom.Initial.util;

public class ResponseObject {
    Object body;
    Integer statusCode;
    String Message;

    public ResponseObject(Object body, Integer statusCode, String message) {
        this.body = body;
        this.statusCode = statusCode;
        Message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
