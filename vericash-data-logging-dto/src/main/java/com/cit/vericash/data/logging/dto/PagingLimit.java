package com.cit.vericash.data.logging.dto;

public class PagingLimit {
    Integer from;
    Integer to;
    public PagingLimit(Integer from, Integer to)
    {
        this.from=from;
        this.to=to;
    }

    public PagingLimit() {
    }

    public Integer getFrom() {
        return from;
    }
    public void setFrom(Integer from) {
        this.from = from;
    }
    public Integer getTo() {
        return to;
    }
    public void setTo(Integer to) {
        this.to = to;
    }
}
