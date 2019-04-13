package com.cit.vericash.common.data.logging.vericashdataqueryservice;

import com.cit.vericash.data.logging.dto.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QueryService {
    @Autowired
    LoggingPresistClient loggingPresistClient;

    @RequestMapping(value = "get_result", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public List<Record> send(@RequestBody FilterMessage filterMessage) {
        String selectConfiguredQuery = getSelectQuery(filterMessage);
        StringBuilder queryAppend = new StringBuilder();
        queryAppend.append(selectConfiguredQuery);
        if (filterMessage.getPagingLimit() != null) {
            queryAppend.append(" limit " + filterMessage.getPagingLimit().getFrom() + "," + filterMessage.getPagingLimit().getTo());
        }
        filterMessage.setQuery(queryAppend.toString());
        ResultSet resultSet = loggingPresistClient.executeQuery(filterMessage);
        return resultSet.getRecords();
    }


    public String getSelectQuery(FilterMessage filterMessage) {
        Gson gson = new Gson();
        String selectQuery = "SELECT `query` FROM module_query INNER JOIN module on module_query.module = module.id @Criteria";
        List<Criteria> criteriaList = new ArrayList<>();
        criteriaList.add(new Criteria("module.module", Criteria.Operator.EQUALS, filterMessage.getModule(), Criteria.Type.NUMBER));
        criteriaList.add(new Criteria("query_name", Criteria.Operator.EQUALS, filterMessage.getQueryName(), Criteria.Type.STRING));
        System.out.println(selectQuery);
        FilterMessage configuredQueryFilterMessage = new FilterMessage();
        configuredQueryFilterMessage.setQuery(selectQuery);
        configuredQueryFilterMessage.setCriteriaList(criteriaList);
        ResultSet resultSet = loggingPresistClient.executeQuery(configuredQueryFilterMessage);
        List<Record> records = resultSet.getRecords();
        String quer = records.get(0).get("`query`");
        return quer;
    }

}

