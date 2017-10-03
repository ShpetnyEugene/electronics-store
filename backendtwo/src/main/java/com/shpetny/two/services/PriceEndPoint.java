package com.shpetny.two.services;

import com.shpetny.two.pojos.GetPriceRequest;
import com.shpetny.two.pojos.GetPriceResponse;
import com.shpetny.two.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;

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
        response.setPrice(priceRepository.findPriceById(request.getId()));
        return response;
    }
}

