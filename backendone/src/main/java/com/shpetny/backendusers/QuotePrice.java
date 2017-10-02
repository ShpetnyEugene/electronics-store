package com.shpetny.backendusers;

import com.shpetny.backendusers.pojos.GetPriceRequest;
import com.shpetny.backendusers.pojos.GetPriceResponse;
import org.apache.log4j.Logger;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class QuotePrice extends WebServiceGatewaySupport {

    private static final Logger log = Logger.getLogger(QuotePrice.class);

    public GetPriceResponse getPriceById(long id){
        GetPriceRequest priceRequest = new GetPriceRequest();
        priceRequest.setId(id);
        return (GetPriceResponse) getWebServiceTemplate()
                .marshalSendAndReceive(priceRequest,
                        new SoapActionCallback("http://localhost:8092/ws/getPriceResponse"));
    }
}
