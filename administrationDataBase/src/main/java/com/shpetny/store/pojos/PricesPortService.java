
package com.shpetny.store.pojos;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PricesPortService", targetNamespace = "soap-products", wsdlLocation = "http://localhost:8092/ws/price.wsdl")
public class PricesPortService
    extends Service
{

    private final static URL PRICESPORTSERVICE_WSDL_LOCATION;
    private final static WebServiceException PRICESPORTSERVICE_EXCEPTION;
    private final static QName PRICESPORTSERVICE_QNAME = new QName("soap-products", "PricesPortService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8092/ws/price.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PRICESPORTSERVICE_WSDL_LOCATION = url;
        PRICESPORTSERVICE_EXCEPTION = e;
    }

    public PricesPortService() {
        super(__getWsdlLocation(), PRICESPORTSERVICE_QNAME);
    }

    public PricesPortService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PRICESPORTSERVICE_QNAME, features);
    }

    public PricesPortService(URL wsdlLocation) {
        super(wsdlLocation, PRICESPORTSERVICE_QNAME);
    }

    public PricesPortService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PRICESPORTSERVICE_QNAME, features);
    }

    public PricesPortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PricesPortService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PricesPort
     */
    @WebEndpoint(name = "PricesPortSoap11")
    public PricesPort getPricesPortSoap11() {
        return super.getPort(new QName("soap-products", "PricesPortSoap11"), PricesPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PricesPort
     */
    @WebEndpoint(name = "PricesPortSoap11")
    public PricesPort getPricesPortSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("soap-products", "PricesPortSoap11"), PricesPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PRICESPORTSERVICE_EXCEPTION!= null) {
            throw PRICESPORTSERVICE_EXCEPTION;
        }
        return PRICESPORTSERVICE_WSDL_LOCATION;
    }

}
