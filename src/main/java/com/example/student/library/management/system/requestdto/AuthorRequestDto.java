package com.example.student.library.management.system.requestdto;

import jakarta.persistence.Column;

public class AuthorRequestDto {

    //request dto - data transfer object
   // it is nothing but taking input from frontend or postman.
   // model class related to database so we should not take input in modal class. Standard way of springboot is to take input using requestdto.

    private String name;
    private String email;
    private String gender;
    private String country;
    private String rating;

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
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
