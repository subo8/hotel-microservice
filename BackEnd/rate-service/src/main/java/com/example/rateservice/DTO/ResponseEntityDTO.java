package com.example.rateservice.DTO;


import com.example.rateservice.model.Rate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntityDTO {
    private Rate rate;
    private Room room;
}
