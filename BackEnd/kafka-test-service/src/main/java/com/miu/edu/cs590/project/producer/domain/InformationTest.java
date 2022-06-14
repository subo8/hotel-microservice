package com.miu.edu.cs590.project.producer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InformationTest {
    private String customerName;
    private String customerPhoneNumber;
    private String email;
    private String typeOfPayment;
    private String address;
    private String roomType;
    private String price;
}
