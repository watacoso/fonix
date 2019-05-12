package com.fonix.db.dao;

import com.fonix.observer.AddObserverDTO;
import com.fonix.observer.ObserverModel;
import com.fonix.util.Frequency;
import org.apache.catalina.util.ParameterMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ObserverJdbcDAO implements ObserverDAO{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private BeanPropertyRowMapper<ObserverModel> observerRowMapper=new BeanPropertyRowMapper(ObserverModel.class);

    @Override
    public ObserverModel get(String mail, String originCode, String destinationCode) {
        String sql="INSERT INTO Observers(email) VALUES(:email)";
        Map<String,Object> params=new HashMap<>();
        params.put("email",mail);

        return jdbcTemplate.queryForObject(sql,
                params,
                observerRowMapper);
    }



    @Override
    public void insertOrUpdate(String mail, String originCode, String destinationCode, Frequency frequency) {
        String sql="INSERT INTO Observers(email) VALUES(:email)";

        Map<String,Object> params=new HashMap<>();
        params.put("email",mail);
        params.put("originCode",originCode);
        params.put("destinationCode",destinationCode);
        params.put("frequency",frequency);
        jdbcTemplate.execute(sql,params, PreparedStatement::execute);
    }
}
