package com.fonix.api;

import com.fonix.aggregator.AddFlightDTO;
import com.fonix.aggregator.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/flight")
public class FlightController {

    @Autowired
    FlightService flightService;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void addFlight(@RequestBody AddFlightDTO dto){
        flightService.addFlight(dto);
    }


}
