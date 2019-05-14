package com.fonix.offerscanner;


import org.springframework.stereotype.Service;

/*
*
* Interface with the objective of retrieving the best offers at the current time
* and forwarding them to the registered observers.
* */

@Service
public interface BestOffersService {


    void deliverBestOffers();


}
