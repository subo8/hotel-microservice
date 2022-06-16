package com.example.rateservice.service;
import com.example.rateservice.model.Rate;
import com.example.rateservice.repository.RateRepository;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class RateServiceTest {
    private RateRepository rateRepository;
    private RateService rateService;
    private RestTemplate restTemplate;
        @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    void setUp(){
        rateRepository = mock(RateRepository.class);
        restTemplate = mock(RestTemplate.class);
        rateService = new RateService(rateRepository,restTemplate);
    }

    @Test
    void updateRateTest(){
        Optional<Rate> rate =Optional.of(new Rate("1", "1", "1", 4)) ;
        when(rateRepository.findById("1")).thenReturn(rate);
        Rate rateToChange=Rate.builder().rating(2).build();
        when(rateRepository.save(rate.get())).thenReturn(rate.get());
        Boolean result= rateService.updateRate("1",rateToChange );
        assertThat(result).isEqualTo(true);
    }

//    @Test
//    void addRateTest() throws JsonProcessingException {
//            Rate rate = new Rate("1","1","1",4);
//        Room room = new Room("1",1,"vip",100.0,"good",2,2,false,"good",true,"4 star",4);
//        rateService.addRate(rate);
//        assertThat(rate.getId()!=null).isEqualTo(true);
//    }

    @Test
    void deleteRateTest(){
        Optional<Rate> rate =Optional.of(new Rate("2", "2", "2", 4)) ;
        when(rateRepository.findById("2")).thenReturn(rate);
        Boolean result= rateService.deleteRate("2" );
        assertThat(result).isEqualTo(true);
    }

}