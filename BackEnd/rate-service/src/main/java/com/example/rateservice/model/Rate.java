package com.example.rateservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Document(collection = "rate")
public class Rate {
    @Id
    private String id;
    private String roomId;
    private String userId;
    private Integer rating;


}
