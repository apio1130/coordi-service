package com.coordi.service.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackages = {
	"com.coordi.service.api",
	"com.coordi.service.application",
	"com.coordi.service.storage"
})
@ConfigurationPropertiesScan
public class CoordiRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoordiRestApiApplication.class, args);
	}

}
