package com.miu.edu.cs590.project.notification.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.edu.cs590.project.notification.common.EmailTemplate;
import com.miu.edu.cs590.project.notification.common.InformationTest;
import com.miu.edu.cs590.project.notification.service.EmailService;
import com.miu.edu.cs590.project.notification.service.InformationTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class KafkaTestListener {

    @Autowired
    EmailService emailService;
    @Autowired
    InformationTestService informationTestService;
    @Value("${even.received}")
    private String eventReceivedSuccessfully;
    @Value("${even.not.received}")
    private String eventNotReceived;

    @KafkaListener(topics = "#{'${spring.kafka.template.default-topic}'}")
    public void handleMessage(String testReceiverString) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            InformationTest informationTest = objectMapper.readValue(testReceiverString, InformationTest.class);
            log.info(eventReceivedSuccessfully);
            String informationBooking = EmailTemplate.createTextEmail(informationTest);
            log.info(informationBooking);
            emailService.sendEmailWithImage(informationBooking, informationTest);
            informationTestService.saveInformationTest(informationTest);

        } catch (JsonProcessingException e) {
            log.error(eventNotReceived);
            log.error(e.toString() );
            throw new RuntimeException(e);
        }

    }

}
