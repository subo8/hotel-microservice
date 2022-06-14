package com.miu.edu.cs590.project.notification.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import java.time.LocalDate;


@Component
@Slf4j
public class KafkaTestListener {
    private final String NEWLINE = System.lineSeparator();

    @KafkaListener(topics = "testing")
    public void handleMessage(String testReceiverString) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            InformationTest informationTest = objectMapper.readValue(testReceiverString, InformationTest.class);
            log.info("The Payment has been made successfully!");
            log.info("Information of the customer is: " + NEWLINE +
                    "Name: " + informationTest.getCustomerName() + NEWLINE +
                    "Phone Number: " + informationTest.getCustomerPhoneNumber() + NEWLINE +
                    "Email: " + informationTest.getEmail() + NEWLINE +
                    "Type of Payment: " + informationTest.getTypeOfPayment() + NEWLINE +
                    "Address: " + informationTest.getAddress() + NEWLINE +
                    "Type of room: " + informationTest.getRoomType() + NEWLINE +
                    "Price " + informationTest.getPrice() + NEWLINE +
                    "Booking Date: " + LocalDate.now());

        } catch (JsonProcessingException e) {
            log.error("Message has not been receive properly");
            log.error(e.toString() );
            throw new RuntimeException(e);
        }

    }

}
