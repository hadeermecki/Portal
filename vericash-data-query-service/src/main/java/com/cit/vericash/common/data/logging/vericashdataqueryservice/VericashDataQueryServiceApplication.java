package com.cit.vericash.common.data.logging.vericashdataqueryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class VericashDataQueryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VericashDataQueryServiceApplication.class, args);
	}
}
