package com.shpetny.store.services;


import com.shpetny.store.pojos.*;
import org.apache.log4j.Logger;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class QuotePrice extends WebServiceGatewaySupport {

    private static final Logger log = Logger.getLogger(QuotePrice.class);

    public GetPriceResponse getPrice(long id) {
        PricesPortService pricesPortService = new PricesPortService();
        PricesPort service = pricesPortService.getPricesPortSoap11();
        GetPriceRequest priceRequest = new GetPriceRequest();
        priceRequest.setId(id);
        return service.getPrice(priceRequest);
    }


    public GetPriceResponse updatePrice(long id, double newValue) {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.shpetny.store.pojos");
        getWebServiceTemplate().setMarshaller(marshaller);
        getWebServiceTemplate().setUnmarshaller(marshaller);
        getWebServiceTemplate().setCheckConnectionForFault(true);
        UpdatePriceRequest updatePriceRequest = new UpdatePriceRequest();
        updatePriceRequest.setId(id);
        updatePriceRequest.setValue(newValue);
        return (GetPriceResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8092/ws/prices.xsd",
                        updatePriceRequest, new SoapActionCallback("http://localhost:8092/ws"));
    }


}
