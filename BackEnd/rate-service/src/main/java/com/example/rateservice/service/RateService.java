package com.example.rateservice.service;
import com.example.rateservice.exception.RateNotExistException;
import com.example.rateservice.model.Rate;
import com.example.rateservice.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class RateService {

    @Autowired
    RateRepository rateRepository;

    public void addRate(Rate rate){
        rateRepository.save(rate);
    }

    public void updateRate(String rateID, Rate rate) {
        Optional< Rate> optionalRate = rateRepository.findById(rateID);
        if (!optionalRate.isPresent())
            throw new RateNotExistException("Rate id is invalid " + rateID);
        rate.setId(rateID);
        rateRepository.save(rate);
    }

    public void deleteRate(String rateID){
        Optional<Rate> optionalRate = rateRepository.findById(rateID);
        if (!optionalRate.isPresent())
            throw new RateNotExistException("Rate id is invalid " + rateID);
        rateRepository.deleteById(rateID);
    }
}
