package com.pq.server3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
@EnableDiscoveryClient
public class Server3Application {

	public static void main(String[] args) {
		SpringApplication.run(Server3Application.class, args);
	}

}
