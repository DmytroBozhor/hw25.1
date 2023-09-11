package com.example.hw25.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories("com.example.hw25.repositories")
public class SpringConfig {
}
