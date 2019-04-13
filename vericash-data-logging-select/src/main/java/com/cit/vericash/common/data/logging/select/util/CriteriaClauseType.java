package com.cit.vericash.common.data.logging.select.util;

public enum CriteriaClauseType {
    WHERE_CRITERIA("Criteria"),
    HAVING_CRITERIA("having");

    private String name;

    CriteriaClauseType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
