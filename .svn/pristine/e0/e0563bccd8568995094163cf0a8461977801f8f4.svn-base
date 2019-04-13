package com.cit.vericash.data.logging.dto;

import java.io.Serializable;

public class Response  implements Serializable{
    private static final long serialVersionUID = 1L;
    private Response.Status status;
    private String result;

    public Response() {
        this.status = Response.Status.ERROR;
    }

    public Response.Status getStatus() {
        return this.status;
    }

    public void setStatus(Response.Status status) {
        this.status = status;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static enum Status {
        SUCCESS,
        ERROR;

        private Status() {
        }
    }
}
