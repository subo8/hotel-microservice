package com.example.rateservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.example.rateservice.jwt.JwtUtils;
import com.example.rateservice.model.Rate;
import com.example.rateservice.repository.RateRepository;
import com.example.rateservice.service.RateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RateControllerTest {

    @MockBean
    RateRepository raterepository;

    @Autowired
    RateService rateService;

    @Autowired
    JwtUtils jwtUtils;

    @Test
    public void findAllRateTest(){
        when(raterepository.findAll()).thenReturn(Stream
                .of(
                        new Rate("1",
                                "1",
                                "1",
                                5),
                        new Rate("2",
                                "2",
                                "2",
                                5)
                        ).collect(Collectors.toList()));

        assertEquals(2, raterepository.findAll().size());
    }

    @Test
    public void insertRateTest(){
        Rate rate = new Rate("62a92e51b35c623b239e6488","62a9c17d5e9f4e550c1ba104",4);
        when(raterepository.save(rate)).thenReturn(rate);
        assertEquals(rate, raterepository.save(rate));
    }

    @Test
    public void deleteRate(){
        Rate rate =  new Rate("62a9c794ec530448782c6f32",
                "62a92e51b35c623b239e6488",
                "62a9c6b673c22b657f6b1bef",
                5);
        raterepository.delete(rate);
        verify(raterepository, times(1)).delete(rate);
    }
}

