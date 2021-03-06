package com.shpetny.backendusers;

import com.shpetny.backendusers.models.Cart;
import com.shpetny.backendusers.models.Product;
import com.shpetny.backendusers.persistance.CartRepository;
import com.shpetny.backendusers.persistance.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

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
                registry.addMapping("/**").
                        allowedOrigins("http://localhost:8091",
                        "http://localhost:8092","http://localhost:8099","*","http://localhost:8091")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
            }
        };
    }
}


/**
 * <Service name="foo">
 <Connector port="80" protocol="org.apache.coyote.http11.Http11NioProtocol" />
 <Engine name="Catalina80" defaultHost="localhost">
 <Host name="localhost" appBase="foo" unpackWARs="true" autoDeploy="true" />
 </Engine>
 </Service>

 <Service name="bar">
 <Connector port="81" protocol="org.apache.coyote.http11.Http11NioProtocol" />
 <Engine name="Catalina81" defaultHost="localhost">
 <Host name="localhost" appBase="bar" unpackWARs="true" autoDeploy="true" />
 </Engine>
 </Service>

 Также создать дв папки с именами артефактов и оба ROOT.war


 The root application won't receive requests that match other applications, e.g. /foo/example will go to foo.war, /example/example will go to ROOT.war
 *
 * */
