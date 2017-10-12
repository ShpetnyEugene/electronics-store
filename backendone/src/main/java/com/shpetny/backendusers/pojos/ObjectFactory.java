package com.shpetny.backendusers.pojos;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {


    public ObjectFactory() {
    }


    public GetPriceResponse createGetResponse() {
        return new GetPriceResponse();
    }

    public GetAllPriceResponse createAllGetResponse() {
        return new GetAllPriceResponse();
    }

    public GetPriceRequest createGetRequest() {
        return new GetPriceRequest();
    }


    public GetAllPriceRequest createAllGetRequest() {
        return new GetAllPriceRequest();
    }


}
