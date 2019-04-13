package com.cit.vericash.common.data.logging.select;

import com.cit.vericash.data.logging.dto.Criteria;
import com.cit.vericash.data.logging.dto.PagingLimit;
import com.cit.vericash.data.logging.dto.Record;

import java.io.Serializable;
import java.util.List;


public interface IGenericDao<T extends Serializable> {
    List<Record> executeNativeQuery(String query, List<Criteria> criteriaList, List<Criteria> havingCriteriaList);

}
