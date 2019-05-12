package com.fonix.mail;

import org.springframework.stereotype.Service;


public interface MailService {

    void send(String email,String message);

}
