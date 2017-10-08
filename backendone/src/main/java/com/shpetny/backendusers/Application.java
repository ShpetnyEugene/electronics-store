package com.shpetny.backendusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8091");
                registry.addMapping("/**").allowedOrigins("http://localhost:8092");
            }
        };
    }

}

// Удалить PRICE - из BACKEND 1

// Вопросы :

// Как прошла перая лекция по Маш
// Как сходили в кино ?

// 0. Spring Безопастность
// 1. через SOAP возможно изменять данные
// 2.

// TODO Pagenas to backeen
// Как собрать maven отдельные варианты


// 1. Сессии на spring ?
// TODO HtttpSession

// 2. БД ?


// 2. Пока я отравляю по  полному URL
// Вставить изи application.properties




// 3. Где нужно делать конфиг на вход ?

