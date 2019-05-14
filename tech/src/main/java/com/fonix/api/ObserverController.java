package com.fonix.api;

import com.fonix.observer.AddObserverDTO;
import com.fonix.observer.ObserverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/observer")
public class ObserverController {

    @Autowired
    private ObserverService observerService;


    /*
    * I made the assumption that the user will insert the same values of origin and destination
    * that will be delivered by the crawler.
    *
    * */

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void addObserver(@RequestBody AddObserverDTO dto){
        observerService.addObserver(dto);
    }

}
