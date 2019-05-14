package com.fonix.db.dao;

import com.fonix.observer.ObserverModel;
import com.fonix.util.Frequency;

import java.math.BigDecimal;
import java.util.Date;

public interface ObserverDAO {

    ObserverModel get(String email);

    void updateStatus(String email, BigDecimal bestOffer, Date newUpdateTime);


    /*
    * I assumed that a particular observer is identified by email, origin and destination.
    * Trying to register with the same informations will mean an update on the update frequency.
    * */

    void insertOrUpdate(String email, String originCode, String destinationCode, Frequency frequency);

}
