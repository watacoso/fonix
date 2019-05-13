package com.fonix.db.dao;

import com.fonix.offerscanner.OfferModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ObserversFlightsJdbcDAO implements ObserversFlightsDAO {
    @Override
    public List<OfferModel> getBestOffersForObservers() {
        return null;
    }
}
