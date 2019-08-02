package com.pq.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
@EnableDiscoveryClient
public class ServerApplication {

	/**
	 * EurekaServer 服务注册中心
	 * URL http://localhost:8761
	 * pq
	 * */
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}
