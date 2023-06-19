package com.david.tfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DavgamesBackendDavidRodriguezCanoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DavgamesBackendDavidRodriguezCanoApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DavgamesBackendDavidRodriguezCanoApplication.class);
	}
}
