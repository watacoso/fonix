package com.fonix.observer;


import com.fonix.util.Frequency;

public class AddObserverDTO {


    private final Integer id;
    private final String email;
    private final String originCode;
    private final String destinationCode;
    private final Frequency frequency;


    public AddObserverDTO(Integer id, String email, String originCode, String destrinationCode, Frequency frequency) {
        this.id = id;
        this.email = email;
        this.originCode = originCode;
        this.destinationCode = destrinationCode;
        this.frequency = frequency;
    }

    public Integer getId() {
        return id;
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
