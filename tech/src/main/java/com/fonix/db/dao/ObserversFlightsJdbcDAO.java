package com.fonix.db.dao;

import com.fonix.offerscanner.OfferModel;
import com.fonix.util.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ObserversFlightsJdbcDAO implements ObserversFlightsDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public List<OfferModel> getBestOffersForObservers() {
        String sql = getBestOffersQuery();
        return jdbcTemplate.query(sql, new RowMapper<OfferModel>() {
            @Override
            public OfferModel mapRow(ResultSet rs, int i) throws SQLException {
                return new OfferModel(
                        rs.getString("email"),
                        rs.getBigDecimal("previousoffer"),
                        rs.getBigDecimal("currentoffer"),
                        rs.getString("origcode"),
                        rs.getString("destcode"),
                        Frequency.valueOf(rs.getString("frequencycode")),
                        rs.getString("flightcode"),
                        rs.getTimestamp("departuredate"));
            }
        });
    }

    /*
    * join (on origin and destination codes) of the flights (starting from current time) with minimum pricing,
    * and the qualified observers.
    * An observer is qualified if it's frequency is uncapped of it's nextUpdate is before the current time.
    * */

    private String getBestOffersQuery() {
        return new StringBuilder()
                .append("WITH bestFlights(origCode,destCode,flightCode,departureDate,minPrice)      ")
                .append("as(                                                                        ")
                .append("  SELECT                                                                   ")
                .append("    origCode,                                                              ")
                .append("    destCode,                                                              ")
                .append("    flightCode,                                                            ")
                .append("    departureDate,                                                         ")
                .append("    min(pricing) as minPrice                                               ")
                .append("    from flights                                                           ")
                .append("    where departureDate>sysdate                                            ")
                .append("    group by  origCode,destCode                                            ")
                .append("    )                                                                      ")
                .append("SELECT o.email,                                                            ")
                .append("  o.bestPrice as previousOffer,                                            ")
                .append("  bf.minPrice as currentOffer,                                             ")
                .append("  o.origCode,                                                              ")
                .append("  o.destCode,                                                              ")
                .append("  o.frequencyCode,                                                         ")
                .append("  bf.flightCode,                                                           ")
                .append("  bf.departureDate                                                         ")
                .append("from observers o                                                           ")
                .append("join bestFlights bf on o.origCode=bf.origCode and o.destCode=bf.destCode   ")
                .append("where o.frequencyCode='UNCAPPED'                                           ")
                .append("OR nextUpdate<sysdate                                                      ")
                .toString();
    }

}
