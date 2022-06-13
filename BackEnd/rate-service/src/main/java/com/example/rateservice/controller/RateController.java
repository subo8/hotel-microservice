package com.example.rateservice.controller;
import com.example.rateservice.model.Rate;
import com.example.rateservice.repository.RateRepository;
import com.example.rateservice.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class RateController {

    @Autowired
    RateRepository raterepository;

    @Autowired
    RateService rateService;

    @GetMapping("/rate")
    public List<Rate> findAll() {
        return raterepository.findAll();
    }

    @PostMapping("/rate")
    public ResponseEntity<?> addProduct(@RequestBody Rate rate) {
        rateService.addRate(rate);
        return new ResponseEntity<>("Rate has been added successfully.", HttpStatus.CREATED);
    }

    @PutMapping("/rate/{rateID}")
    public ResponseEntity<?> updateRate(@PathVariable("rateID") String rateID,
                                           @RequestBody @Valid Rate rate) {
        rateService.updateRate(rateID,rate);
        return new ResponseEntity<>("Rate has been updated successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/rate/{rateID}")
    public ResponseEntity<?> deleteRate(@PathVariable("rateID") String rateID) {
        rateService.deleteRate(rateID);
        return new ResponseEntity<>("Rate has been deleted successfully.", HttpStatus.OK);
    }

}
