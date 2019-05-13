package com.fonix.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MailTestService implements MailService{

    Logger logger = LoggerFactory.getLogger(MailTestService.class);

    @Override
    public void send(String email, String message) {


        String s=String.format("\nTo: %s \n\n %s ",email,message);

        logger.info(s);
    }
}
