package com.example.movierental.service;

import com.example.movierental.dto.UserDTO;
import com.example.movierental.dto.login.UserLoginDTO;
import com.example.movierental.enums.Role;
import com.example.movierental.model.User;
import com.example.movierental.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean authenticateUser(UserLoginDTO userLoginDTO) {
        System.out.println(" Before db connection ");
        Boolean isUser = userRepository.existsByUsername(userLoginDTO.getUsername());
        System.out.println(" is user present  "+isUser);

        User user = userRepository.findByUsername(userLoginDTO.getUsername());
        System.out.println(" after db connection ");

        if (user != null && user.getPassword().equals(userLoginDTO.getPassword())) {
            // TODO: Implement real password encryption and comparison
            System.out.println("User infor "+user);
            return true;
        }
        return false;
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        // Check if the username or email already exists
        if (userRepository.existsByUsername(userDTO.getUsername()) || userRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalStateException("Username or email already exists");
        }
        // Map UserDTO to User entity, save it, and then map back to UserDTO to return
        User user = mapToEntity(userDTO);
        User savedUser = userRepository.save(user);
        userDTO.setUserID(savedUser.getUserID());
        return userDTO;
    }

    private User mapToEntity(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(Role.valueOf(userDTO.getRole().toUpperCase())); // Adjust based on your Role enum
        user.setIsActive(userDTO.getIsActive());
        user.setContactDetails(userDTO.getContactDetails());
        return user;
    }
}
