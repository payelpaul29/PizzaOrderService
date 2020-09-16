package com.test.sw.PizzaOrder;

import java.sql.SQLException;


import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.test.sw.PizzaOrder"})
@EnableAutoConfiguration
public class PizzaOrderApplication {
	
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server inMemoryH2DatabaseaServer() throws SQLException {
		 return Server.createTcpServer(
	      "-tcp", "-tcpAllowOthers", "-tcpPort", "8080");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PizzaOrderApplication.class, args);
	}

}
