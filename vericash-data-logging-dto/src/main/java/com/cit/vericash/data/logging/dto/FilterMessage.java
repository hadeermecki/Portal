package com.cit.vericash.data.logging.dto;

import java.util.List;

public class FilterMessage {

    private String module;
    private String queryName;
    private String query;
    private List<Criteria> criteriaList;
    private Having having ;
    private PagingLimit pagingLimit;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Having getHaving() {return having; }
    public void setHaving(Having having) { this.having = having; }
    public List<Criteria> getCriteriaList() {
        return criteriaList;
    }
    public void setCriteriaList(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }
    public String getModule() {
        return module;
    }
    public void setModule(String module) {
        this.module = module;
    }
    public PagingLimit getPagingLimit() {
        return pagingLimit;
    }
    public void setPagingLimit(PagingLimit pagingLimit) {
        this.pagingLimit = pagingLimit;
    }
    public String getQueryName() {
        return queryName;
    }
    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

}
