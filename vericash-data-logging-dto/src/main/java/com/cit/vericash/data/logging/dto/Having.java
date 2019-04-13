package com.cit.vericash.data.logging.dto;

import java.util.List;

public class Having {

    public List<Criteria> getCriteriaList() {
        return criteriaList;
    }


    public Having() {
    }

    public void setCriteriaList(List<Criteria> criteriaList) {

        this.criteriaList = criteriaList;
    }

    private List<Criteria> criteriaList ;

    public Having(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }
}
