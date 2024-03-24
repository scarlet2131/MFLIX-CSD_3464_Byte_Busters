package com.example.movierental.model;

import com.example.movierental.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "`User`")// Using backticks for case sensitivity in some databases
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID", nullable = false)
    @Getter
    private Integer userID;

    @Setter
    @Column(name="username", nullable = false)
    private String username;

    @Setter
    @Column(name="email", nullable = false)
    private String email;

    @Setter
    @Column(name="password", nullable = false)
    private String password;

    public String getPassword() {
        return password;
    }

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @Setter
    @Column(name="is_active")
    private Boolean isActive;

    @Setter
    @Column(name="contact_details")
    private String contactDetails;

}
