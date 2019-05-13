package com.fonix.db.dao;

import com.fonix.observer.ObserverModel;
import com.fonix.util.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ObserverJdbcDAO implements ObserverDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private BeanPropertyRowMapper<ObserverModel> observerRowMapper = new BeanPropertyRowMapper(ObserverModel.class);

    @Override
    public ObserverModel get(String email) {
        String sql = "SELECT  email,origcode,destcode,frequencycode from Observers where id=:id";
        Map<String, Object> params = new HashMap<>();
        params.put("email", email);


        return jdbcTemplate.queryForObject(sql,
                params,
                observerRowMapper);
    }

    @Override
    public void updateStatus(String email, BigDecimal bestPrice, Date nextUpdate) {
        String sql = "UPDATE Observers SET bestPrice=:bestPrice,nextUpdate=:nextUpdate where email=:email";

        Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        params.put("bestPrice", bestPrice);
        params.put("nextUpdate", nextUpdate);

        jdbcTemplate.execute(sql, params, PreparedStatement::execute);
    }

    @Override
    public void insertOrUpdate(String email, String originCode, String destinationCode, Frequency frequency) {

        String insertSql = "INSERT  INTO Observers(email,origCode,destCode,frequencyCode)" +
                " VALUES(:email,:origCode,:destCode,:frequencyCode)";

        String updateSql = "UPDATE Observers SET frequencyCode=:frequencyCode " +
                "WHERE email=:email " +
                "AND origCode=:origCode " +
                "AND destCode=:destCode";


        Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        params.put("origCode", originCode);
        params.put("destCode", destinationCode);
        params.put("frequencyCode", frequency.name());
        try {
            jdbcTemplate.execute(insertSql, params, PreparedStatement::execute);
        } catch (DuplicateKeyException ex) {
            jdbcTemplate.execute(updateSql, params, PreparedStatement::execute);
        }
    }
}
