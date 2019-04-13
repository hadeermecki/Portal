package com.cit.vericash.common.data.logging.persist;

import com.cit.vericash.data.logging.dto.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class AbstractJpaDao<T extends Serializable> implements IGenericDao<Serializable> {

	@PersistenceContext
	@Autowired
    private EntityManager entityManager;
	@Override
	@Transactional
	public void create(Object entity) {
		entityManager.merge(entity);
	}

	@Override
	@Transactional
	public void update(Object entity) {
		entityManager.merge(entity);
		//entityManager.refresh(entity);
	}

	@Override
	public void delete(String queryStr) {
		Query query = entityManager.createNativeQuery(queryStr);
		query.executeUpdate();
	}

    @Override
    public void updateNativeQuery(String queryStr) {
        Query query = entityManager.createNativeQuery(queryStr);
        query.executeUpdate();
    }

    @Override
	public void deleteById(long entityId) {
		// T entity = (T) findOne(entityId);
		// delete(entity);
	}


}
