package com.livanov.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;

public class TestPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.from(PlaygroundApplication::main)
                .with(ContainerConfiguration.class)
                .with()
                .run(
                        "--logging.level.org.springframework.jdbc=DEBUG"
                );
    }

    @TestConfiguration(proxyBeanMethods = false)
    public static class ContainerConfiguration {

        @Bean
        @RestartScope
        @ServiceConnection
        public PostgreSQLContainer<?> postgreSqlContainer() {
            return new PostgreSQLContainer<>("postgres:14.6-alpine")
                    .withUsername("postgres")
                    .withPassword("postgres");
        }
    }
}