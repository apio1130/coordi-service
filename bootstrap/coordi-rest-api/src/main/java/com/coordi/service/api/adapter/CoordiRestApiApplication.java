package com.coordi.service.api.adapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackages = {
	"com.coordi.service.api.adapter",
	"com.coordi.service.application",
	"com.coordi.service.storage.adapter"
})
@ConfigurationPropertiesScan
public class CoordiRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoordiRestApiApplication.class, args);
	}

}
