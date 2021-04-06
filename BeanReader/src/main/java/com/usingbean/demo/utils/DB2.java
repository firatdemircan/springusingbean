package com.usingbean.demo.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration//you have to specify that, its a configuration file
@PropertySource("classpath:application.properties")//you need to show the file which you are reading
public class DB2 {

    @Value("${database2.datasource.url}")
    private String url;

    @Value("${database2.datasource.username}")
    private String username;

    @Value("${database2.datasource.password}")
    private String password;

    @Value("${database2.datasource.driver-class-name}")
    private String driverClassName;

    @Bean(name="db")//this method will bring us a connection object
    public DriverManagerDataSource source(){
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        return datasource;

    }

}
