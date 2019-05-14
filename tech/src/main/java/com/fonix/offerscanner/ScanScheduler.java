package com.fonix.offerscanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScanScheduler {

    @Autowired
    BestOffersService bestOffersService;

    /*
    *
    * For the case of uncapped observers, i decided for an approach that unbounds the
    * insertion of a new flight or observer from the scan operation, at the loss of
    * instant updates regarding the offers.
    * */

    @Scheduled(fixedRateString = "${scanner.scheduler.interval.millis}")
    public void execute() {
        bestOffersService.deliverBestOffers();
    }

}
