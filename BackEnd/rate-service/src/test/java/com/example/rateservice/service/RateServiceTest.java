package com.example.rateservice.service;

import com.example.rateservice.exception.RateNotExistException;
import com.example.rateservice.model.Rate;
import com.example.rateservice.repository.RateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
class RateServiceTest {

    private RateService rateService;

    @Mock
    private RateRepository rateRepository;

    @Mock
    private RestTemplate restTemplate;


    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    void setUp(){

    }
//    public boolean updateRate(String rateID,Rate rate) {
//        Optional< Rate> optionalRate = rateRepository.findById(rateID);
//        if (!optionalRate.isPresent())
//            throw new RateNotExistException("Rate id is invalid " + rateID);
//        Rate rateToBeUpdate= optionalRate.get();
//        if(rate.getRating()!=null){
//            rateToBeUpdate.setRating(rate.getRating());
//        }
//        rateRepository.save(rateToBeUpdate);
//        return true;
//    }

    @Test
    void show_success_message_when_updateRate_returns_value() {
        rateService = new RateService(rateRepository, null);
        Optional<Rate> rate =Optional.of(new Rate("62a9c794ec530448782c6f32", "62a92e51b35c623b239e6488", "62a9c6b673c22b657f6b1bef", 4)) ;
        when(rateRepository.findById("62a9c794ec530448782c6f32")).thenReturn(rate);
        Rate rateToChange=Rate.builder().rating(2).build();
        when(rateRepository.save(rate.get())).thenReturn(rate.get());
        Boolean result= rateService.updateRate("62a9c794ec530448782c6f32",rateToChange );
        assertThat(result).isEqualTo(true);
    }

    public void deleteRate(String rateID){
        Optional<Rate> optionalRate = rateRepository.findById(rateID);
        if (!optionalRate.isPresent())
            throw new RateNotExistException("Rate id is invalid " + rateID);
        rateRepository.deleteById(rateID);
    }

    @Test
    void show_success_when_delete(){
        rateService = new RateService(rateRepository, null);
        Optional<Rate> rate =Optional.of(new Rate("62a9c794ec530448782c6f32", "62a92e51b35c623b239e6488", "62a9c6b673c22b657f6b1bef", 4)) ;
        when(rateRepository.findById("62a9c794ec530448782c6f32")).thenReturn(rate);
        Rate rateToChange=Rate.builder().rating(2).build();
    }

    @Test
    void updateRate() {
    }

    @Test
    void deleteRate() {
    }
}