package com.shpetny.backendusers.pojos;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {
    private final static QName _String_QNAME = new QName("http://www.webserviceX.NET/", "string");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.webservicex
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPriceResponse }
     *
     */
    public GetPriceResponse createGetQuoteResponse() {
        return new GetPriceResponse();
    }

    /**
     * Create an instance of {@link GetPriceRequest }
     *
     */
    public GetPriceRequest createGetQuote() {
        return new GetPriceRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.webserviceX.NET/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }
}
