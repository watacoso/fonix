package com.fonix.observer;


import com.fonix.util.Frequency;

public class ObserverModel {


    private final String email;
    private final String originCode;
    private final String destinationCode;
    private final Frequency frequency;



    public ObserverModel(String email, String originCode, String desrinationCode, Frequency frequency) {
        this.email = email;
        this.originCode = originCode;
        this.destinationCode = desrinationCode;
        this.frequency = frequency;
    }

    public String getEmail() {
        return email;
    }

    public String getOriginCode() {
        return originCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public Frequency getFrequency() {
        return frequency;
    }
}
