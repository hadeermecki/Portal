package com.cit.vericash.common.data.logging.vericashdataloggingservice;

import com.cit.vericash.data.logging.dto.Query;
import com.cit.vericash.data.logging.dto.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("logging-persist-service")
public interface LoggingPresistClient {
    @RequestMapping(value = "logging_dao_service/query/execute", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Response executeQuery(Query query);
}
