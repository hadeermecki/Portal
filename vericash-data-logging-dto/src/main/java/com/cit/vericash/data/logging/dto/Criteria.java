package com.cit.vericash.data.logging.dto;

public class Criteria {
    private String column;
    private Object value;
    private Operator operator;
    private Type type;

    public Criteria(String column, Operator operator, Object value, Type type)
    {
        this.column=column;
        this.value=value;
        this.operator=operator;
        this.type=type;
    }

    public Criteria() {
    }

    public enum Operator
    {
        EQUALS,
        NotEquals,
        GREATER_THAN,
        LESS_THAN,
        CONTAINS,
        RANGE,
        GREATER_THAN_OR_EQUALS,
        LESS_THAN_OR_EQUALS,
        EXPRESSION,
        Contains,
        IN;

    }

    public enum Type
    {
        STRING,
        NUMBER,
        DATE,
        Date_Time;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
