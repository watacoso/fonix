package com.fonix.offerscanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScanScheduler {

    @Autowired
    BestOffersService bestOffersService;



    @Scheduled(fixedRate = 5000)
    public void execute() {
        bestOffersService.deliverBestOffers();
    }

}
