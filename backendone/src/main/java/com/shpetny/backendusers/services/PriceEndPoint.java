package com.shpetny.backendusers.services;


import com.shpetny.backendusers.persistance.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class PriceEndPoint {
    private static final String NAMESPACE_URL= "soap-products";

    private final PriceRepository priceRepository;


    @Autowired
    public PriceEndPoint(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }


//    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getPriceRequest")
//    @ResponsePayload
//    public GetPriceResponse getPrice (@RequestPayload GetPriceRequest request){
//        GetPriceResponse response = new GetPriceResponse();
//    }

}
