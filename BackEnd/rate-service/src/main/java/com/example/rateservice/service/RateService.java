package com.example.rateservice.service;
import com.example.rateservice.DTO.ResponseEntityDTO;
import com.example.rateservice.DTO.Room;
import com.example.rateservice.exception.RateNotExistException;
import com.example.rateservice.model.Rate;
import com.example.rateservice.repository.RateRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class RateService {

    @Autowired
    RateRepository rateRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void addRate(Rate rate) throws JsonProcessingException {
        ResponseEntityDTO vo = new ResponseEntityDTO();
        ObjectMapper objectMapper = new ObjectMapper();
        Rate rate1 = new Rate();
        Room room = restTemplate.getForObject("http://localhost:8088/room/{roomId}", Room.class, rate.getRoomId());
       // room.setRoomRating(rate.getRating());
        room.setTotalRatings(rate.getRating());

        if (rate.getRating()>=5){
            room.setRoomRating("5 star");
        }else if (rate.getRating()>=4){
            room.setRoomRating("4 star");
        }else {
            room.setRoomRating("Moderate");
        }

        String roomString = objectMapper.writeValueAsString(room);
        restTemplate.put("http://localhost:8088/room/", roomString,String.class);
        vo.setRate(rate1);
        vo.setRoom(room);
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
