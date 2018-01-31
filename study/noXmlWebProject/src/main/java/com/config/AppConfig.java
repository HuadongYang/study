package com.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = "com.xxg", excludeFilters = {@Filter(value = Controller.class)})
public class AppConfig {
	
	{
		System.out.println("AppConfig start ------------");
	}

	@Value("${jdbc.driverClassName}")  
    private String driverClassName;  
       
    @Value("${jdbc.url}")  
    private String url;  
   
    @Value("${jdbc.username}")  
    private String username;  
   
    @Value("${jdbc.password}")  
    private String password;  
    
    @Bean  
    public static PropertyPlaceholderConfigurer loadProperties() {  
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();  
        ClassPathResource resource = new ClassPathResource("jdbc.properties");  
        configurer.setLocations(resource);  
        return configurer;  
    }
    
    @Bean(destroyMethod = "close")  
    public DataSource dataSource() {  
        BasicDataSource dataSource = new BasicDataSource();  
        dataSource.setDriverClassName(driverClassName);  
        dataSource.setUrl(url);  
        dataSource.setUsername(username);  
        dataSource.setPassword(password);  
        return dataSource;  
    } 
    
}
