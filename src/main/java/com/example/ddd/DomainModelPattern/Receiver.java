package com.example.ddd.DomainModelPattern;

import javax.persistence.Column;

public class Receiver {

    private String receiverName;                     //받는 사람
    private String receiverPhoneNumber;


    public String getReceiverName() {
        return receiverName;
    }


    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public Receiver() {
    }

    public Receiver(String receiverName, String receiverPhoneNumber) {
        this.receiverName = receiverName;
        this.receiverPhoneNumber = receiverPhoneNumber;
    }




}


