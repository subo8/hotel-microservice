package com.example.rateservice.controller;
import com.example.rateservice.jwt.JwtUtils;
import com.example.rateservice.model.Rate;
import com.example.rateservice.repository.RateRepository;
import com.example.rateservice.service.RateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
public class RateController {

    @Autowired
    RateRepository raterepository;

    @Autowired
    RateService rateService;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/")
    public List<Rate> findAll() {
        return raterepository.findAll();
    }
    @PostMapping("/")
    public ResponseEntity<?> addProduct(@RequestBody Rate rate, HttpServletRequest request) throws JsonProcessingException {
        Cookie cookie = WebUtils.getCookie(request, "subo8");
        if(cookie!=null){
            String jwt = cookie.getValue();
            String userId = jwtUtils.getUserIdFromJwtToken(jwt);
            rate.setUserId(userId);
            rateService.addRate(rate);
            return new ResponseEntity<>("Rate has been added successfully.", HttpStatus.CREATED);

        }
        else {
            return new ResponseEntity<>("Please Login first.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{rateID}")
    public ResponseEntity<?> updateRate(@PathVariable("rateID") String rateID,
                                           @RequestBody @Valid Rate rate) {
        rateService.updateRate(rateID,rate);
        return new ResponseEntity<>("Rate has been updated successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/{rateID}")
    public ResponseEntity<?> deleteRate(@PathVariable("rateID") String rateID) {
        rateService.deleteRate(rateID);
        return new ResponseEntity<>("Rate has been deleted successfully.", HttpStatus.OK);
    }

}
