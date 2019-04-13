package com.cit.vericash.common.data.logging.persist;

import com.cit.vericash.data.logging.dto.Record;

import java.io.Serializable;
import java.util.List;


public interface IGenericDao<T extends Serializable> {
    void create(Object entity);

    void update(Object entity);

    void delete(String query);

    void updateNativeQuery( String queryStr);

    void deleteById(final long entityId);

}
