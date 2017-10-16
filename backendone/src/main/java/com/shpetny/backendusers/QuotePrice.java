package com.shpetny.backendusers;


import com.shpetny.backendusers.pojos.GetPriceRequest;
import com.shpetny.backendusers.pojos.GetPriceResponse;
import org.apache.log4j.Logger;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class QuotePrice extends WebServiceGatewaySupport {

    private static final Logger log = Logger.getLogger(QuotePrice.class);

    public GetPriceResponse getPrice(long id) {

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.shpetny.backendusers.pojos");
        getWebServiceTemplate().setMarshaller(marshaller);
        getWebServiceTemplate().setUnmarshaller(marshaller);

        GetPriceRequest priceRequest = new GetPriceRequest();
        priceRequest.setId(id);
        return (GetPriceResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8092/ws/prices.xsd",
                        priceRequest, new SoapActionCallback("http://localhost:8092/ws"));
    }

}
