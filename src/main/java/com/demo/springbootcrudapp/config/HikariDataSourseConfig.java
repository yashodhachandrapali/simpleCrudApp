package com.demo.springbootcrudapp.config;

import com.zaxxer.hikari.HikariConfig;
import lombok.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


public class HikariDataSourseConfig {

    public DataSource dbDataSource(String jdbcUrl, String user, String driverClass, String password, String maxPoolSize,
                                   String minIdleSize, long idleTimeout) {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driverClass);
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(user);
        config.setPassword(password);
        config.setMaximumPoolSize(Integer.parseInt(maxPoolSize));
        config.setMinimumIdle(Integer.parseInt(minIdleSize));
        config.setIdleTimeout(idleTimeout);
        return new com.zaxxer.hikari.HikariDataSource(config);
    }

}
