package com.fonix.offerscanner;

//Transactionally notify an obsterver and update it's status in the database

import com.fonix.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

@Service
public class NotifyObserverServiceImpl implements NotifyObserverService {


    @Autowired
    MailService mailService;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");

    @Override
    public void sendNotification(OfferModel offerModel) {

        String msg = buildMessage(offerModel);
        mailService.send(offerModel.getEmail(), msg);

    }

    private String buildMessage(OfferModel offerModel) {

        String from = offerModel.getOriginCode();
        String to = offerModel.getDestinationCode();


        String currentOffer = offerModel.getCurrentBestOffer().toPlainString();

        String flightCode = offerModel.getFlightCode();
        String dateTime = sdf.format(offerModel.getDepartureTime());

        String priceChangeString=String.format("The price is now %s !\n\n", currentOffer);
        if(offerModel.getPreviousBestOffer()!=null){
            String prevOffer = offerModel.getPreviousBestOffer().toPlainString();
            priceChangeString=String.format("The price has gone changed, From %s to %s !\n\n", prevOffer, currentOffer);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Update on flights from %s to %s!\n", from, to))
                .append(priceChangeString)
                .append(String.format("Flight code: %s", flightCode))
                .append(String.format("\nDeparture: %s", dateTime))
                .append("\n\nRegards,")
                .append("\n\nFonix");

        return sb.toString();
    }
}
