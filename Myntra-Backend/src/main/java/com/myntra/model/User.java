package com.myntra.model;

import java.time.LocalDate;

public class User {
    public String userName;
    public String email;
    public LocalDate registrationDate;

    public User(String userName, String email, LocalDate registrationDate) {
        this.userName = userName;
        this.email = email;
        this.registrationDate = registrationDate;
    }
}
