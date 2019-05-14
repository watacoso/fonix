package com.fonix.offerscanner;

import com.fonix.db.dao.ObserverDAO;
import com.fonix.db.dao.ObserversFlightsDAO;
import com.fonix.util.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.Date;
import java.util.List;

@Service
public class BestOffersServiceImpl implements BestOffersService {

    @Autowired
    private NotifyObserverService notifyObserverService;

    @Autowired
    private ObserversFlightsDAO observersFlightsDAO;

    @Autowired
    ObserverDAO observerDAO;

    /*
    * Retrieve the list of qualified observers together with the best flight offer avaiable.
    *Then, updates each observer status.
    * */
    @Override
    public void deliverBestOffers() {


        List<OfferModel> bestOffers=observersFlightsDAO.getBestOffersForObservers();

        bestOffers.forEach(this::updateObserver);

    }


    /*
    * Transactionally update the table with the new avaiable best offer and an incremented update time.
    * in the presence of a change of price, send a notification to the observer.
    * */
    @Transactional
    protected void updateObserver(OfferModel offerModel){

        BigDecimal prevOffer=offerModel.getPreviousBestOffer();
        BigDecimal currentOffer=offerModel.getCurrentBestOffer();
        LocalDateTime dateTime=LocalDateTime.ofInstant(offerModel.getDepartureTime().toInstant(), ZoneId.systemDefault());

        Frequency frequency=offerModel.getFrequency();

        switch (frequency){
            case DAILY:
                dateTime= dateTime.plusDays(1);
                break;
            case WEEKLY:
                dateTime=dateTime.plusWeeks(1);
                break;
            case MONTHLY:
                dateTime=dateTime.plusMonths(1);
                break;
        }

        Date nextUpdate= Date.from(dateTime
                .atZone(ZoneId.systemDefault())
                .toInstant());

        observerDAO.updateStatus(offerModel.getEmail(),
                offerModel.getCurrentBestOffer(),
                nextUpdate);

        if(prevOffer==null ||!currentOffer.equals(prevOffer)){
            notifyObserverService.sendNotification(offerModel);
        }

    }


}
