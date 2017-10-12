package com.shpetny.store.pojos;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() {
    }

    public GetPriceResponse createGetQuoteResponse() {
        return new GetPriceResponse();
    }

    public GetPriceRequest createGetQuote() {
        return new GetPriceRequest();
    }

    public UpdatePriceRequest createUpdatePriceRequest(){
        return new UpdatePriceRequest();
    }

    public Price createPrice() {
        return new Price();
    }
}
