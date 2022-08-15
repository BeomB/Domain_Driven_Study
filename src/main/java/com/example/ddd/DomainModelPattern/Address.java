package com.example.ddd.DomainModelPattern;

public class Address {

    private String shippingAddress1;                 //주소
    private String shippingAddress2;
    private String shippingAddress3;
    private String zipcode;

    public String getShippingAddress1() {
        return shippingAddress1;
    }


    public String getShippingAddress2() {
        return shippingAddress2;
    }

    public String getShippingAddress3() {
        return shippingAddress3;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Address(String shippingAddress1, String shippingAddress2, String shippingAddress3, String zipcode) {
        this.shippingAddress1 = shippingAddress1;
        this.shippingAddress2 = shippingAddress2;
        this.shippingAddress3 = shippingAddress3;
        this.zipcode = zipcode;
    }
}
