package com.shpetny.backendusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
//@ComponentScan("com.shpetny.*")
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").
                        allowedOrigins("http://localhost:8091",
                        "http://localhost:8092","*","http://localhost:8091")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
            }
        };
    }
}
/*
2. TODO SOAP WSDL
4. TODO


















* TODO PROBLEMS :
*  2. Не работает SOAP CONSUMING
*  3.
*
*  // Fidler
*
*
*
* */



















// TODO Problems:
// 1. Не собираестя проект - maven package
// 2.

// Удалить PRICE - из BACKEND 1

// Вопросы :

// 1. Price in DB - Back-End 1


// 1. через SOAP возможно изменять данные
/// TODO +
// 2. Filter ajax


// TODO Pagenas to backeen


// 1. Сессии на spring ?
// TODO HtttpSession

// 2. БД ?


// 2. Пока я отравляю по  полному URL
// Вставить изи application.properties


// 3. Где нужно делать конфиг на вход ?

