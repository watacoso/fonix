package com.fonix.aggregator;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.beans.ConstructorProperties;
import java.math.BigDecimal;
import java.util.Date;

public class AddFlightDTO {


    private final String originCode;
    private final String destinationCode;
    private final String flightCode;
    private final Date departureDate;
    private final BigDecimal pricing;

    @ConstructorProperties({"email", "origin", "destination", "flight", "departureDate", "pricing"})
    public AddFlightDTO(String originCode, String destinationCode, String flightCode, @JsonFormat(pattern = "yyyyMMdd") Date departureDate, BigDecimal pricing) {
        this.originCode = originCode;
        this.destinationCode = destinationCode;
        this.flightCode = flightCode;
        this.departureDate = departureDate;
        this.pricing = pricing;
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
}
