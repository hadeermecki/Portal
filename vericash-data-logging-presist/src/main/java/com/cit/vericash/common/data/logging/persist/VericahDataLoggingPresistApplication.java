package com.cit.vericash.common.data.logging.persist;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EntityScan(basePackages="com.cit.vericash.data.logging.model")
@ComponentScan("com.cit.vericash.common.data.logging.persist")
@EnableFeignClients
@EnableDiscoveryClient
public class VericahDataLoggingPresistApplication {

	public static void main(String[] args) {
		SpringApplication.run(VericahDataLoggingPresistApplication.class, args);
	}
}
