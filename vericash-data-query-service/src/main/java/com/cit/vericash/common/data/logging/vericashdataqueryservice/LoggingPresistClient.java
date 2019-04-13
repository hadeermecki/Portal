package com.cit.vericash.common.data.logging.vericashdataqueryservice;

import com.cit.vericash.data.logging.dto.FilterMessage;
import com.cit.vericash.data.logging.dto.Query;
import com.cit.vericash.data.logging.dto.Response;
import com.cit.vericash.data.logging.dto.ResultSet;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("logging-select-service")
public interface LoggingPresistClient {
    @RequestMapping(value = "/execute-query", method = RequestMethod.POST)
    public ResultSet executeQuery(@RequestBody FilterMessage filterMessage);

}
