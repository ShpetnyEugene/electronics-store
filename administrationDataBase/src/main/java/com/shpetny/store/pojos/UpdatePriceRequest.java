package com.shpetny.store.pojos;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id","value","productId"
})
@XmlRootElement(name = "updatePriceRequest")
public class UpdatePriceRequest {
    @XmlElement
    protected long id;

    @XmlElement
    protected double value;


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Gets the value of the id property.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(long value) {
        this.id = value;
    }

}
