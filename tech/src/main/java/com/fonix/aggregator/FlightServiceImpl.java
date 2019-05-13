package com.fonix.aggregator;

import com.fonix.db.dao.FlightDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightDAO flightDAO;

    @Override
    public void addFlight(AddFlightDTO dto) {
        flightDAO.insertOrUpdate(dto.getOriginCode(),dto.getDestinationCode(),dto.getFlightCode(),dto.getDepartureDate(),dto.getPricing());
    }
}
