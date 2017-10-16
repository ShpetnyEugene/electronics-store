package com.shpetny.backendusers.configs;

import com.shpetny.backendusers.QuotePrice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class PriceConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.shpetny.backendusers.pojos");
        return marshaller;
    }

    @Bean
    public QuotePrice quotePrice(Jaxb2Marshaller marshaller) {
        QuotePrice price = new QuotePrice();
        price.setDefaultUri("http://localhost:8092/ws/prices.wsdl");
        price.setMarshaller(marshaller);
        price.setUnmarshaller(marshaller);
        return price;
    }
}