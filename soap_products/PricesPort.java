
package soap_products;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PricesPort", targetNamespace = "soap-products")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PricesPort {


    /**
     * 
     * @param getPriceRequest
     * @return
     *     returns soap_products.GetPriceResponse
     */
    @WebMethod
    @WebResult(name = "getPriceResponse", targetNamespace = "soap-products", partName = "getPriceResponse")
    public GetPriceResponse getPrice(
        @WebParam(name = "getPriceRequest", targetNamespace = "soap-products", partName = "getPriceRequest")
        GetPriceRequest getPriceRequest);

    /**
     * 
     * @param updatePriceRequest
     */
    @WebMethod
    @Oneway
    public void updatePrice(
        @WebParam(name = "updatePriceRequest", targetNamespace = "soap-products", partName = "updatePriceRequest")
        UpdatePriceRequest updatePriceRequest);

}
