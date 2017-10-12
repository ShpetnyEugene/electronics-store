package com.shpetny.two.services;

import com.shpetny.two.PriceRepository;
import com.shpetny.two.pojos.GetPriceRequest;
import com.shpetny.two.pojos.GetPriceResponse;
import com.shpetny.two.pojos.Price;
import com.shpetny.two.pojos.UpdatePriceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class PriceEndPoint {
    private static final String NAMESPACE_URI = "soap-products";

    private PriceRepository priceRepository;

    @Autowired
    public PriceEndPoint(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPriceRequest")
    @ResponsePayload
    public GetPriceResponse getPrice(@RequestPayload GetPriceRequest request) {
        GetPriceResponse response = new GetPriceResponse();
        List<Price> prices = new ArrayList<>();
        if (request.getId() == 0) {
            prices = (List<Price>) priceRepository.findAll();
        } else {
            prices.add(priceRepository.findPriceById(request.getId()));
        }
        response.setPrice(prices);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updatePriceRequest")
    @ResponsePayload
    public GetPriceResponse updatePrice(@RequestPayload UpdatePriceRequest request) {
        GetPriceResponse response = new GetPriceResponse();
        List<Price> prices = new ArrayList<>();
        if(priceRepository.findPriceById(request.getId()) == null){
            return response;

        }
        prices.add(priceRepository.findPriceById(request.getId()));
        Price price = new Price(request.getValue(),prices.get(0).getProductId());
        price.setId(request.getId());
        priceRepository.save(price);
        response.setPrice(prices);
        return response;
    }
}

