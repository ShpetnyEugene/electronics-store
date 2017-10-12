package com.shpetny.store.pojos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder="price")
@XmlRootElement(name = "getPriceResponse")
public class GetPriceResponse {

    @XmlElement(name = "Price")

    protected List<Price> price;

    public List<Price> getPrice() {
        return price;
    }

    public void setPrice(List<Price> price) {
        this.price = price;
    }
}
