package model;

import validation.EmailValidator;

import java.time.LocalDate;
import java.time.Period;

public class User {

    private String name;
    private String email;
    private LocalDate dateOfBirth;

    public User(String name, String email, LocalDate dateOfBirth) {
        this.name = name;
        setEmail(email);
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (EmailValidator.isValid(email)) {
            this.email = email;
        } else {
            this.email = null;
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return Period.between(
                dateOfBirth,
                LocalDate.now()
        ).getYears();
    }
}