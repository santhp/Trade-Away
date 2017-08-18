package com.tw.tradeaway.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column (name = "firstName", nullable = false)
    String firstName;
    @Column(name="lastName", nullable = false)
    String lastName;
    @Column(name="emailId", nullable = false)
    String emailId;
    @Column(name="phoneNumber", nullable = false)
    String phoneNumber;
    @Column(name="role", nullable = false)
    String role;
    @Column(name="address", nullable = false)
    String address;
    @Column(name="password", nullable = false)
    String password;


    public User(String firstName, String lastName, String emailId, String phoneNumber, String role, String address, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.address = address;
        this.password = password;
    }

    public User() {
    }


}
