package com.cit.vericash.common.data.logging.select;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages="com.cit.vericash.data.logging.model")
@ComponentScan("com.cit.vericash.common.data.logging.select")
@EnableFeignClients
@EnableDiscoveryClient
public class VericashDataLoggingSelectApplication {

	public static void main(String[] args) {
		SpringApplication.run(VericashDataLoggingSelectApplication.class, args);
	}
}
