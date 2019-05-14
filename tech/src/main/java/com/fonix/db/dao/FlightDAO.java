package com.fonix.db.dao;



import java.math.BigDecimal;
import java.util.Date;


public interface FlightDAO {


    /*
    * I assumed that the crawler can obtain the same flights but with a different price. To manage this, i decided
    * to update the corresponding record with the new price.
    *
    * */

    void insertOrUpdate(String origCode, String destCode, String flightCode, Date departureDate, BigDecimal pricing);

}
