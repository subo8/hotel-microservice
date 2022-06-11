package com.miu.edu.cs590.project.producer.controller;

import com.miu.edu.cs590.project.producer.domain.InformationTest;
import com.miu.edu.cs590.project.producer.service.KafkaSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestingKafkaController {

    @Autowired
    KafkaSenderService kafkaSenderService;

    @PostMapping("/producer")
    public ResponseEntity<?> testingKafkaSender(@RequestBody InformationTest informationTest) {
        kafkaSenderService.receiveEvent(informationTest);
        return new ResponseEntity<String>("New Event has been sent to the notification server", HttpStatus.OK);
    }

}
