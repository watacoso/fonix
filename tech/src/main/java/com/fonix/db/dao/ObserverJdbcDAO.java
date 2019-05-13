package com.fonix.db.dao;

import com.fonix.observer.AddObserverDTO;
import com.fonix.observer.ObserverModel;

import com.fonix.util.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ObserverJdbcDAO implements ObserverDAO{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private BeanPropertyRowMapper<ObserverModel> observerRowMapper=new BeanPropertyRowMapper(ObserverModel.class);

    @Override
    public ObserverModel get(Integer id) {
        String sql="SELECT  id,email,origcode,destcode,frequencycode from Observers where id=:id";
        Map<String,Object> params=new HashMap<>();
        params.put("id",id);


        return jdbcTemplate.queryForObject(sql,
                params,
                observerRowMapper);
    }

    @Override
    public void updateStatus(Integer id, BigDecimal bestPrice, Date nextUpdate) {
        String sql="UPDATE Observers SET bestPrice=:bestPrice,nextUpdate=:nextUpdate where id=:id";

        Map<String,Object> params=new HashMap<>();
        params.put("id",id);
        params.put("bestPrice",bestPrice);
        params.put("nextUpdate",nextUpdate);

        jdbcTemplate.execute(sql,params, PreparedStatement::execute);
    }

    @Override
    public void insertOrUpdate(String mail, String originCode, String destinationCode, Frequency frequency) {
        String sql="INSERT INTO Observers(email,origCode,destCode,frequencyCode) VALUES(:email,:origCode,:destCode,:frequencyCode)";

        Map<String,Object> params=new HashMap<>();
        params.put("email",mail);
        params.put("origCode",originCode);
        params.put("destCode",destinationCode);
        params.put("frequencyCode",frequency.name());
        jdbcTemplate.execute(sql,params, PreparedStatement::execute);
    }
}
