package com.shpetny.two.pojos;


import com.shpetny.two.Price;

import javax.xml.bind.annotation.XmlRegistry;


@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() {
    }


    public GetPriceResponse createGetQuoteResponse() {
        return new GetPriceResponse();
    }

    /**
     */
    public GetPriceRequest createGetQuote() {
        return new GetPriceRequest();
    }


    public Price createPrice(){
        return new Price();
    }
}
