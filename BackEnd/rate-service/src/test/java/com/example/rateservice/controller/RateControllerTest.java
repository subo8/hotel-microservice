package com.example.rateservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.example.rateservice.jwt.JwtUtils;
import com.example.rateservice.model.Rate;
import com.example.rateservice.repository.RateRepository;
import com.example.rateservice.service.RateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RateControllerTest {

    @MockBean
    RateRepository raterepository;

    @InjectMocks
    RateService rateService;

    @InjectMocks
    JwtUtils jwtUtils;

    @Test
    public void findAllRateTest(){
        List<Rate> rates = new ArrayList<>();
        rates.add(new Rate("1","1","1",4));
        rates.add(new Rate("2","2","2",4));
        when(raterepository.findAll()).thenReturn(rates);
        assertEquals(2, raterepository.findAll().size());
    }

    @Test
    public void insertRateTest(){
        Rate rate = new Rate("1","1",4);
        when(raterepository.save(rate)).thenReturn(rate);
        assertEquals(rate, raterepository.save(rate));
    }

    @Test
    public void deleteRate(){
        Rate rate =  new Rate("1", "1", "1", 5);
        raterepository.delete(rate);
        verify(raterepository, times(1)).delete(rate);
    }
}

