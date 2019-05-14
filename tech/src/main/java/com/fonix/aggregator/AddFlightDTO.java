package com.fonix.aggregator;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import java.beans.ConstructorProperties;
import java.io.InvalidObjectException;
import java.math.BigDecimal;
import java.util.Date;

public class AddFlightDTO {


    private final String originCode;
    private final String destinationCode;
    private final String flightCode;
    private final Date departureDate;
    private final BigDecimal pricing;

    @ConstructorProperties({"email", "origin", "destination", "flight", "departureDate", "pricing"})
    public AddFlightDTO(String originCode, String destinationCode, String flightCode, @JsonFormat(pattern = "yyyyMMddHHmm") Date departureDate, BigDecimal pricing) throws InvalidObjectException {
        this.originCode = originCode;
        this.destinationCode = destinationCode;
        this.flightCode = flightCode;
        this.departureDate = departureDate;
        this.pricing = pricing;
        validate();
    }


    public String getOriginCode() {
        return originCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public String getFlightCode() {
        return flightCode;
    }

    @DateTimeFormat(pattern = "yyyyMMddHH24MM")
    public Date getDepartureDate() {
        return departureDate;
    }

    public BigDecimal getPricing() {
        return pricing;
    }

    private void validate() throws InvalidObjectException {
        if(!StringUtils.hasText(originCode)
        || !StringUtils.hasText(destinationCode)
                || !StringUtils.hasText(flightCode)
                || departureDate==null
                || pricing==null || pricing.compareTo(BigDecimal.valueOf(0))<0){
            throw new InvalidObjectException("Flight input is not valid");
        }
    }
}
