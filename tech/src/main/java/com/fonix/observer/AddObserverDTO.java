package com.fonix.observer;


import com.fonix.util.Frequency;
import com.fonix.util.Regex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.io.InvalidObjectException;

public class AddObserverDTO {





    private final String email;
    private final String originCode;
    private final String destinationCode;
    private final Frequency frequency;


    public AddObserverDTO(String email, String originCode, String destinationCode, Frequency frequency) throws InvalidObjectException {

        this.email = email;
        this.originCode = originCode;
        this.destinationCode = destinationCode;
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

        if (!StringUtils.hasText(email) || !email.matches(Regex.EMAIL_PATTERN.getPattern())
                || !StringUtils.hasText(originCode)
                || !StringUtils.hasText(destinationCode)
                || frequency == null) {
            throw new InvalidObjectException("ObserverDTO input is not valid");
        }

    }
}
