package com.sa.logging;

import com.sa.logging.ELKService;
import com.sa.logging.RestService;
import com.fasterxml.jackson.databind.JsonNode;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/api")
public class LoggingController {

    private static final Logger log = LoggerFactory.getLogger(LoggingController.class);

    private final ELKService service;

    private final RestService restService;

    public LoggingController(ELKService service, RestService restService) {
        this.service = service;
        this.restService = restService;
    }

    @GetMapping(value = "/hello")
    public String helloWorld() {
        log.info("Inside Hello World Function");
        String response = "Hello World! " + new Date();
        log.info("Response => {}", response);
        return response;
    }

    @GetMapping(value = "/Food-Details")
    public JSONArray foodDetails() {
        log.info("Inside Food Detail Function");
        return service.getAllFoodDetails();
    }

    @GetMapping(value = "/weather/{city}")
    public JsonNode getWeatherInformation(@PathVariable String city) {
        return restService.getPostsPlainJSON(city);
    }
}
