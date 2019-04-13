package com.cit.vericash.common.data.logging.select;

import com.cit.vericash.common.data.logging.select.util.CriteriaClauseAppender;
import com.cit.vericash.common.data.logging.select.util.CriteriaClauseType;
import com.cit.vericash.data.logging.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DaoService {

    @Autowired
    private IGenericDao dao;

    public ResultSet executeQuery(FilterMessage filterMessage) {
        ResultSet resultSet = new ResultSet();
        List<Criteria> whereCriteriaList = filterMessage.getCriteriaList() != null ? filterMessage.getCriteriaList() : new ArrayList<Criteria>();
        List<Criteria> havingCriteriaList = filterMessage.getHaving() != null ? filterMessage.getHaving().getCriteriaList() : new ArrayList<Criteria>();
        String selectQueryStr = filterMessage.getQuery();
        System.out.println(selectQueryStr);
        selectQueryStr = CriteriaClauseAppender.append(whereCriteriaList, selectQueryStr, CriteriaClauseType.WHERE_CRITERIA);
        selectQueryStr = CriteriaClauseAppender.append(havingCriteriaList, selectQueryStr, CriteriaClauseType.HAVING_CRITERIA);
        if (whereCriteriaList.size() == 0) {
            selectQueryStr = selectQueryStr.replace("@Criteria", "");
        }
        System.out.println("The query:" + selectQueryStr);
        List<Record> records = null;

        records = dao.executeNativeQuery(selectQueryStr, whereCriteriaList, havingCriteriaList);

        resultSet.setRecords(records);
        return resultSet;
    }

}