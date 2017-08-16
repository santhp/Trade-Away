package com.tw.tradeaway;

public class LoginResponse {
    int id;
    String firstName, lastName, email, role, token;

    public LoginResponse(int id, String firstName, String lastName, String email, String role, String token) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getToken() {
        return token;
    }
}
