package com.fonix.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FlightJdbcDAO implements FlightDAO {


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void insertOrUpdate(String origCode, String destCode, String flightCode, Date departureDate, BigDecimal pricing) {
        String insertSql="INSERT INTO Flights(origCode,destCode,flightCode,departureDate,pricing) " +
                "VALUES(:origCode,:destCode,:flightCode,:departureDate,:pricing)";

        String updateSql="UPDATE Flights SET pricing=:pricing " +
                "WHERE origCode=:origCode " +
                "AND destCode=:destCode " +
                "AND flightCode=:flightCode " +
                "AND CAST(departureDate as TIMESTAMP)=CAST(:departureDate as TIMESTAMP)";

        Map<String,Object> params=new HashMap<>();
        params.put("origCode",origCode);
        params.put("destCode",destCode);
        params.put("flightCode",flightCode);
        params.put("departureDate",departureDate);
        params.put("pricing",pricing);
        try {
            jdbcTemplate.execute(insertSql, params, PreparedStatement::execute);
        } catch (DuplicateKeyException ex) {
            jdbcTemplate.execute(updateSql, params, PreparedStatement::execute);
        }
    }
}
