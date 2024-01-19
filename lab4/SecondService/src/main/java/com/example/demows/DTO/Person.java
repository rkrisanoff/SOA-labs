package com.example.demows.DTO;


import lombok.Data;

@Data
public class Person {
    private String name;
    private String passportID;
    private String nationality;
    private Location location;
}
