package com.weather.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	
	@Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://us-cdbr-east-02.cleardb.com:3306/heroku_27e1c07a6c4ccb7?serverTimezone=UTC"); //URL de base / puerto / nombre de la base
        dataSourceBuilder.username("bb9b49d61801ad");
        dataSourceBuilder.password("1ab71e5e");
        return dataSourceBuilder.build();
    }

}
