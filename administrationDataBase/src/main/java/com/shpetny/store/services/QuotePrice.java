package com.shpetny.store.services;


import com.shpetny.store.pojos.GetPriceRequest;
import com.shpetny.store.pojos.GetPriceResponse;
import com.shpetny.store.pojos.UpdatePriceRequest;
import org.apache.log4j.Logger;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class QuotePrice extends WebServiceGatewaySupport {

    private static final Logger log = Logger.getLogger(QuotePrice.class);

    public GetPriceResponse getPrice(long id){

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.shpetny.store.pojos");
        getWebServiceTemplate().setMarshaller(marshaller);
        getWebServiceTemplate().setUnmarshaller(marshaller);
        getWebServiceTemplate().setCheckConnectionForFault(true);

        GetPriceRequest priceRequest = new GetPriceRequest();
        priceRequest.setId(id);
        return (GetPriceResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8092/ws/prices.xsd",
                        priceRequest, new SoapActionCallback("http://localhost:8092/ws"));
    }


    public GetPriceResponse updatePrice(long id,double newValue){

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
