package com.shpetny.two.pojos;

import com.shpetny.two.Price;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder={"price"})
@XmlRootElement(name = "getPriceResponse")
public class GetPriceResponse {

    @XmlElement(required = true)
    protected Price price;

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
