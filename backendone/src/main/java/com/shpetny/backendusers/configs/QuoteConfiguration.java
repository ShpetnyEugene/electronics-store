//package com.shpetny.backendusers.configs;
//
//import com.shpetny.backendusers.QuotePrice;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//
//@Configuration
//public class QuoteConfiguration {
//
//    @Bean
//    public Jaxb2Marshaller marshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        // this package must match the package in the <generatePackage> specified in
//        // pom.xml
//        marshaller.setContextPath("prices.xsd");
//        return marshaller;
//    }
//
//    @Bean
//    public QuotePrice quoteClient(Jaxb2Marshaller marshaller) {
//        QuotePrice price = new QuotePrice();
//        price.setDefaultUri("http://www.webservicex.com/stockquote.asmx");
//        price.setMarshaller(marshaller);
//        price.setUnmarshaller(marshaller);
//        return price;
//    }
//
//}