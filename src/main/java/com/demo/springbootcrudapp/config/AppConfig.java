package com.demo.springbootcrudapp.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@Component
@PropertySource("file:./config/application-${spring.profiles.active}.properties")
public class AppConfig {


    private String jdbcUrl;
    private String user;
    private String driverClass;
    private String password;
    private String maxPoolSize;
    private String minIdlePooleSize;
    private long idleTimeout;

    /**
     * @param jdbcUrl
     * @param user
     * @param password
     * @param maxPoolSize
     */
    public AppConfig(@Value("${jdbc.url}") String jdbcUrl,
                     @Value("${jdbc.username}") String user,
                     @Value("${jdbc.driverClassName}") String driverClass,
                     @Value("${jdbc.password}") String password,
                     @Value("${max-pool-size}") String maxPoolSize,
                     @Value("${min-pool-size}") String minIdlePooleSize,
                     @Value("${app.idleTimeout}") long idleTimeout) {
        this.jdbcUrl = jdbcUrl;
        this.user = user;
        this.driverClass = driverClass;
        this.password = password;
        this.maxPoolSize = maxPoolSize;
        this.minIdlePooleSize = minIdlePooleSize;
        this.idleTimeout = idleTimeout;
    }

    /**
     * Configure HikariDataSource
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {

        HikariDataSourseConfig hikariDataSource = new HikariDataSourseConfig();
        return hikariDataSource.dbDataSource(jdbcUrl, user, driverClass, password, maxPoolSize, minIdlePooleSize, idleTimeout);
    }

    /**
     * Configure NamedParameterJdbcTemplate
     */
    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        System.out.println("Driver " + driverClass);
        return new NamedParameterJdbcTemplate(dataSource());
    }


    /**
     * Configure JdbcTemplate
     */
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

}
