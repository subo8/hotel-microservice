package com.miu.edu.cs590.project.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miu.edu.cs590.project.producer.domain.InformationTest;
import com.miu.edu.cs590.project.producer.domain.Sender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaSenderServiceImpl implements KafkaSenderService {

    @Autowired
    Sender sender;
    @Value("${topic.value}")
    private String topic;

    @Override
    public void receiveEvent(InformationTest informationTest) {

        log.info("Object: " + informationTest);
        ObjectMapper objectMapper = new ObjectMapper();
        String createInformationTestAsString = null;
        try {
            log.info("Before Sending Topic");
            createInformationTestAsString = objectMapper.writeValueAsString(informationTest);
            sender.send(topic, createInformationTestAsString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        sender.send(topic, createInformationTestAsString);
    }
}
