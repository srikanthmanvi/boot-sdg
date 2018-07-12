package io.pivotal.support.sdg.starter.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;
import org.springframework.data.gemfire.config.annotation.EnableLocator;
import org.springframework.data.gemfire.config.annotation.EnableManager;

@CacheServerApplication
@SpringBootApplication
@EnableLocator
@EnableManager(start = true)
public class SpringBootStarterGeodeServer {

	public static void main(String args[]) {
		SpringApplication.run(SpringBootStarterGeodeServer.class, args);
	}

}
