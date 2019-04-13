package com.cit.vericash.common.data.logging.select;

import com.cit.vericash.data.logging.dto.Criteria;
import com.cit.vericash.data.logging.dto.PagingLimit;
import com.cit.vericash.data.logging.dto.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AbstractJpaDao<T extends Serializable> implements IGenericDao<Serializable> {

    @PersistenceContext
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Record> executeNativeQuery(String queryStr, List<Criteria> criteriaList, List<Criteria> havingCriteriaList) {

        List<Record> records = new ArrayList<Record>();
        String[] querryArr = queryStr.split(" ");
        String[] columns = querryArr[1].split(",");
        System.out.println("column length" + columns.length);
        Query query = entityManager.createNativeQuery(queryStr);
        for (int i = 0; i < criteriaList.size(); i++) {
            Criteria criteria = criteriaList.get(i);
            String columnParameter = criteria.getColumn().replace(".", "_");
            columnParameter = columnParameter.replace("\\(", "");
            columnParameter = columnParameter.replace("\\)", "");
            System.out.println(" paramter name :" + criteria.getColumn());
            System.out.println("paramter Value :" + criteria.getValue().toString());
            if (criteria.getOperator() == Criteria.Operator.IN) {
                System.out.println(criteria.getValue().toString());
                query.setParameter(columnParameter, criteria.getValue());

            } else if (criteria.getOperator() == Criteria.Operator.RANGE) {
                ArrayList<Object> value = (ArrayList<Object>) criteria.getValue();

                System.out.println(value.get(0));
                System.out.println(value.get(1));
                query.setParameter(columnParameter + "1", value.get(0));
                query.setParameter(columnParameter + "2", value.get(1));

            } else if (criteria.getOperator() == Criteria.Operator.Contains) {
                query.setParameter(columnParameter, "%" + criteria.getValue() + "%");
                System.out.println(criteria.getValue());

            } else {
                query.setParameter(columnParameter, criteria.getValue());
            }

        }
        if (havingCriteriaList != null) {
            for (int j = 0; j < havingCriteriaList.size(); j++) {
                Criteria havingCriteria = havingCriteriaList.get(j);
                System.out.println(" paramter name :" + havingCriteria.getColumn());
                System.out.println("paramter Value :" + havingCriteria.getValue().toString());
                String paramterName = havingCriteria.getColumn();
                if (paramterName.contains(")")) {
                    paramterName = paramterName.replaceAll("\\(", "");
                    paramterName = paramterName.replaceAll("\\)", "");
                }
                query.setParameter(paramterName, havingCriteria.getValue().toString());

            }
        }

        List<?> results = query.getResultList();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < results.size(); i++) {
            Record record = new Record();
            System.out.println(results.get(i));

            if (results.get(i) instanceof Object[]) {
                Object[] result = (Object[]) results.get(i);
                for (int j = 0; j < columns.length; j++) {
                    Object columnValue = result[j];
                    if (columnValue instanceof Date) {
                        columnValue = dateFormat.format(columnValue);
                    }
                    if (columnValue instanceof java.sql.Date) {
                        columnValue = dateFormat.format(columnValue);
                    }
                    record.setField(columns[j], columnValue == null ? "" : columnValue.toString());
                }
            } else {

                Object result = (Object) results.get(i);
                for (int j = 0; j < columns.length; j++) {

                    record.setField(columns[j], result != null ? result.toString() : "");
                }
            }

            records.add(record);
        }

        return records;
    }

}

