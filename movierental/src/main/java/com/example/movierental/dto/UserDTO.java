package com.example.movierental.dto;

import com.example.movierental.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserDTO {
    private Integer userID; // Auto-generated, no validation needed here

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    private String role = Role.USER.toString(); // Consider using an Enum if you have predefined roles

    private Boolean isActive = true;

    private String contactDetails; // Optional, no @NotNull needed unless required
}

