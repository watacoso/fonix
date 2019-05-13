package com.fonix.db.dao;

import com.fonix.observer.ObserverModel;
import com.fonix.util.Frequency;

import java.math.BigDecimal;
import java.util.Date;

public interface ObserverDAO {

    ObserverModel get(Integer id);

    void updateStatus(Integer id, BigDecimal bestOffer, Date newUpdateTime);

    void insertOrUpdate(String mail, String originCode, String destinationCode, Frequency frequency);

}
