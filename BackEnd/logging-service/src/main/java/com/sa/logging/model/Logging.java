package com.sa.logging.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logging {
    @PrimaryKey
    private UUID id;
    private String user_id;
    private String booking_id;
    private boolean payment_id;
}
