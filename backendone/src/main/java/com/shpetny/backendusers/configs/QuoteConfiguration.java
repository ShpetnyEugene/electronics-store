//package com.shpetny.backendusers.configs;
//
//import com.shpetny.backendusers.QuotePrice;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//
//@Configuration
//public class QuoteConfiguration {
//
//    @Bean
//    public Jaxb2Marshaller marshaller() {
////        JAXBContext.newInstance("prices");
//
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setContextPath("com.shpetny.backendusers.pojos");
//        return marshaller;
//    }
//
//    @Bean
//    public QuotePrice quotePrice(Jaxb2Marshaller marshaller) {
//        QuotePrice price = new QuotePrice();
//        price.setDefaultUri("http://www.webservicex.com/stockquote.asmx");
//        price.setMarshaller(marshaller);
//        price.setUnmarshaller(marshaller);
//        return price;
//    }
//}