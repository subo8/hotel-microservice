package com.example.rateservice.controller;

import com.example.rateservice.model.Rate;
import com.example.rateservice.service.RateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ControllterTest2.class})
public class ControllterTest2 {

    @Mock
    RateService rateService;

    @InjectMocks
    RateController rateController;

    List<Rate> rates;
    Rate rate;

    @Test
    public void getAllRateTest(){
        rates = new ArrayList<Rate>();
        rates.add(new Rate("1","1","1",4));
        rates.add(new Rate("1","1","1",5));
        when(rateService.findAll()).thenReturn(rates);
        ResponseEntity<List<Rate>> rates = rateController.findAll();
        assertThat(HttpStatus.FOUND).isEqualTo(rates.getStatusCode());
        assertThat(2).isEqualTo(rates.getBody().size());
    }

}
