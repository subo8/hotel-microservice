package com.miu.edu.cs590.project.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class InformationTest {

    private String customerName;
    private String customerPhoneNumber;
    private String email;
    private String typeOfPayment;
    private String address;
    private String roomType;
    private String price;

}
