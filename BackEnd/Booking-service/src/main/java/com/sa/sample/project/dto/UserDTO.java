package com.sa.sample.project.dto;

import org.springframework.data.annotation.Id;

public class UserDTO {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;


}
