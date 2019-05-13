package com.fonix.offerscanner;

//Transactionally notify an obsterver and update it's status in the database

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotifyObserverServiceImpl implements NotifyObserverService{


    @Override
    @Transactional
    public void sendNotification(OfferModel offerModel) {

    }
}
