package com.example.movierental.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Integer userID;
    private String username;
    private String email;
    private String password;
    private String role;
    private Boolean isActive;
    private String contactDetails;

}
