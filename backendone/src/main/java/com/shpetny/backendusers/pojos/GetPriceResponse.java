package com.shpetny.backendusers.pojos;

import com.shpetny.backendusers.models.Price;

import javax.xml.bind.annotation.XmlElement;

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
