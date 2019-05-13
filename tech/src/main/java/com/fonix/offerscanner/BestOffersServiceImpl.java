package com.fonix.offerscanner;

import com.fonix.db.dao.ObserversFlightsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BestOffersServiceImpl implements BestOffersService {

    @Autowired
    private NotifyObserverService notifyObserverService;

    @Autowired
    private ObserversFlightsDAO observersFlightsDAO;

    @Override
    public void deliverBestOffers() {
        List<OfferModel> bestOffers=observersFlightsDAO.getBestOffersForObservers();

        bestOffers.forEach(notifyObserverService::sendNotification);

    }


}
