package com.cit.vericash.data.logging.dto;

public class Message {
    private  String entityModelAsJson;
    private  String entityModelClassPath;

    public Message() {
    }

    public Message(String entityModelAsJson, String entityModelClassPath) {
        this.entityModelAsJson = entityModelAsJson;
        this.entityModelClassPath = entityModelClassPath;
    }

    public String getEntityModelAsJson() {

        return entityModelAsJson;

    }

    public void setEntityModelAsJson(String entityModelAsJson) {
        this.entityModelAsJson = entityModelAsJson;
    }

    public String getEntityModelClassPath() {
        return entityModelClassPath;
    }

    public void setEntityModelClassPath(String entityModelClassPath) {
        this.entityModelClassPath = entityModelClassPath;
    }
}
