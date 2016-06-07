package com.jleber.simple.bin.validator.model;

import java.io.Serializable;

/**
 * Created by jleber on 06/06/16.
 */
public class CreditCardInfo implements Serializable {

    private static final long serialVersionUID = -5153604026675554801L;

    private String brand;
    private String cvv;
    private String length;

    public CreditCardInfo(String brand, String length, String cvv) {
        this.brand = brand;
        this.length = length;
        this.cvv = cvv;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "CreditCardInfo[" +
                "brand='" + brand + '\'' +
                ", cvv='" + cvv + '\'' +
                ", length='" + length + '\'' +
                ']';
    }
}