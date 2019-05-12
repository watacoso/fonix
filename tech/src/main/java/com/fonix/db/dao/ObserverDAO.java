package com.fonix.db.dao;

import com.fonix.observer.ObserverModel;
import com.fonix.util.Frequency;

public interface ObserverDAO {

    ObserverModel get(String mail, String originCode, String destinationCode);

    void insertOrUpdate(String mail, String originCode, String destinationCode, Frequency frequency);

}
