package com.fonix.observer;

import com.fonix.db.dao.ObserverDAO;
import com.fonix.mail.MailService;
import com.fonix.util.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddObserverServiceImpl implements AddObserverService {

    @Autowired
    ObserverDAO observerDAO;

    @Autowired
    MailService mailService;

    @Override
    public void addObserver(AddObserverDTO dto) {
        observerDAO.insertOrUpdate(dto.getEmail(),dto.getOriginCode(),dto.getDestrinationCode(),dto.getFrequency());
        String msg=buildConfirmationMessage(dto.getOriginCode(),dto.getDestrinationCode(),dto.getFrequency());
        mailService.send(dto.getEmail(),msg);
    }

    private String buildConfirmationMessage(String origin, String destination, Frequency frequency){
        return new StringBuilder()
                .append("Your subscription is confirmed!\n")
                .append(String.format("You will receive new offers for flights from %s to %s \n",origin,destination))
                .append(String.format("With % frequency!",frequency))
                .toString();
    }

}
