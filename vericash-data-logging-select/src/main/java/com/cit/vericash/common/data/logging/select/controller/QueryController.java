package com.cit.vericash.common.data.logging.select.controller;


import com.cit.vericash.common.data.logging.select.DaoService;
import com.cit.vericash.data.logging.dto.FilterMessage;
import com.cit.vericash.data.logging.dto.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class QueryController {

    @Autowired
    DaoService daoService;

    @RequestMapping(value = "/execute-query", method = RequestMethod.POST)
    public ResultSet executeQuery(@RequestBody FilterMessage filterMessage) {
        ResultSet queryResult = daoService.executeQuery(filterMessage);
        return queryResult;
    }


}
