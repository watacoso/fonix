package com.fonix.offerscanner;

//Transactionally notify an obsterver and update it's status in the database

public interface NotifyObserverService {

    void sendNotification(OfferModel offerModel);

}
