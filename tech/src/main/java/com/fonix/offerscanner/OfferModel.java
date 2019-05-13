package com.fonix.offerscanner;

import com.fonix.util.Frequency;

import java.math.BigDecimal;
import java.util.Date;

public class OfferModel {

    private final String email;
    private final String originCode;
    private final String destinationCode;
    private final String flightCode;
    private final Date departureDate;
    private final BigDecimal previousBestOffer;
    private final BigDecimal currentBestOffer;
    private final Frequency frequency;


    public OfferModel(
                      String email,
                      BigDecimal previousBestOffer,
                      BigDecimal currentBestOffer,
                      String originCode,
                      String destinationCode,
                      Frequency frequency,
                      String flightCode,
                      Date departureDate
    ) {

        this.email = email;
        this.originCode = originCode;
        this.destinationCode = destinationCode;
        this.flightCode = flightCode;
        this.departureDate = departureDate;
        this.previousBestOffer = previousBestOffer;
        this.currentBestOffer = currentBestOffer;
        this.frequency=frequency;
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

    public String getFlightCode() {
        return flightCode;
    }

    public Date getDepartureTime() {
        return departureDate;
    }

    public BigDecimal getPreviousBestOffer() {
        return previousBestOffer;
    }

    public BigDecimal getCurrentBestOffer() {
        return currentBestOffer;
    }

    public Frequency getFrequency() {
        return frequency;
    }
}
