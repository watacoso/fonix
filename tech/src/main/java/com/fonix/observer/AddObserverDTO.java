package com.fonix.observer;


import com.fonix.util.Frequency;

public class AddObserverDTO {


    private final String email;
    private final String originCode;
    private final String destinationCode;
    private final Frequency frequency;


    public AddObserverDTO(String email, String originCode, String destrinationCode, Frequency frequency) {

        this.email = email;
        this.originCode = originCode;
        this.destinationCode = destrinationCode;
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
