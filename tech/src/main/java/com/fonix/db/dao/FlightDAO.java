package com.fonix.db.dao;



import java.math.BigDecimal;
import java.util.Date;


public interface FlightDAO {

    void insertOrUpdate(String origCode, String destCode, String flightCode, Date departureDate, BigDecimal pricing);

}
