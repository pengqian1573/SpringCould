package com.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ClientApplication {
	/**
	 * localhost:8881/actuator/bus-refresh  刷新地址。
	 * */
	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}


	@Value("${foo}")
	String foo;
	@RequestMapping(value = "/hi")
	public String hi(@RequestParam String name){
		return foo +" :" + name;
	}
}
