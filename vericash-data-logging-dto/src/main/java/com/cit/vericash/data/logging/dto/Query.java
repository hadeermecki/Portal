package com.cit.vericash.data.logging.dto;

import java.io.Serializable;

public class Query implements Serializable {
    private String queryObject;
    private String entityModelClassPath;
    private Type type;
    public Query(){}
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        INSERT, UPDATE, DELETE, SELECT, UPDATE_NATIVE;
    }

    public String getQueryObject() {
        return queryObject;
    }

    public void setQueryObject(String queryObject) {
        this.queryObject = queryObject;
    }

    public String getEntityModelClassPath() {
        return entityModelClassPath;
    }

    public void setEntityModelClassPath(String entityModelClassPath) {
        this.entityModelClassPath = entityModelClassPath;
    }

}
