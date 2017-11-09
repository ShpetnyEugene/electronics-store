package com.shpetny.adminspanel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan({"com.shpetny.backendusers.services", "com.shpetny.adminspanel.controllers"})
@EnableJpaRepositories("com.shpetny.backendusers.persistance")
@EntityScan("com.shpetny.backendusers.models")
public class Application {

    @Value("${app.backenduser.url}")
    private String backendUserUrl;

    @Value("${app.frontedadmin.url}")
    private String frontedAdminUrl;

    @Value("${app.fronteduser.url}")
    private String frontedUserUrl;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").
                        allowedOrigins(backendUserUrl,
                                frontedAdminUrl, "*", frontedUserUrl)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
            }
        };
    }
}
