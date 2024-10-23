package com.coordi.service.storage.adapter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {

	@Bean
	@ConfigurationProperties(prefix = "infra.storage")
	public HikariConfig h2DbHikariConfig() {
		return new HikariConfig();
	}

	@Bean
	public HikariDataSource h2DbDataSource(HikariConfig h2DbHikariConfig) {
		return new HikariDataSource(h2DbHikariConfig);
	}
}
