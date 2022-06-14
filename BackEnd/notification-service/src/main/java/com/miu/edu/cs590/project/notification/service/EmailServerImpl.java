package com.miu.edu.cs590.project.notification.service;

import com.miu.edu.cs590.project.notification.common.InformationTest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServerImpl implements EmailService {

    @Autowired
    JavaMailSender javaMailSender;
    @Value("${email.address}")
    private String emailSender;

    @Value("${email.subject}")
    private String emailSubject;

    @Override
    public void sendEmailWithImage(String emailInfo, InformationTest informationTest) {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {

            helper = new MimeMessageHelper(message, true);
            helper.setSubject(emailSubject);
            helper.setFrom(emailSender);
            helper.setTo(informationTest.getEmail());
            helper.setText(emailInfo, true);

            javaMailSender.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }


}
