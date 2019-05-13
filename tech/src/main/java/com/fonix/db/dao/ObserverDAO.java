package com.fonix.db.dao;

import com.fonix.observer.ObserverModel;
import com.fonix.util.Frequency;

import java.math.BigDecimal;
import java.util.Date;

public interface ObserverDAO {

    ObserverModel get(String email);

    void updateStatus(String email, BigDecimal bestOffer, Date newUpdateTime);

    void insertOrUpdate(String email, String originCode, String destinationCode, Frequency frequency);

}
