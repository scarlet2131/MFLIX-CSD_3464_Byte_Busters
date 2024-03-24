package com.example.movierental.service;

import com.example.movierental.dto.UserDTO;
import com.example.movierental.dto.login.UserLoginDTO;

public interface UserService {
    boolean authenticateUser(UserLoginDTO userLoginDTO);
    UserDTO registerUser(UserDTO userDTO);
}
