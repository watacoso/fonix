package com.fonix.observer;


import com.fonix.util.Frequency;
import com.fonix.util.Regex;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import java.io.InvalidObjectException;


public class ObserverModel {


    private final String email;
    private final String originCode;
    private final String destinationCode;
    private final Frequency frequency;



    public ObserverModel(String email, String originCode, String desrinationCode, Frequency frequency) throws InvalidObjectException {
        this.email = email;
        this.originCode = originCode;
        this.destinationCode = desrinationCode;
        this.frequency = frequency;
        validate();
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

    private void validate() throws InvalidObjectException {
        if(!StringUtils.hasText(email) || !email.matches(Regex.EMAIL_PATTERN.getPattern())
        || !StringUtils.hasText(originCode)
        || !StringUtils.hasText(destinationCode)
        || frequency==null){
            throw new InvalidObjectException("ObserverModel input is not valid");
        }

    }
}
