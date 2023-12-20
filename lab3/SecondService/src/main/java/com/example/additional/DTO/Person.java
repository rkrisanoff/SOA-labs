package com.example.additional.DTO;


import lombok.Data;
import lombok.Setter;

@Data
public class Person {
    private String name;
    private String passportID;
    private String nationality;
    private Location location;
}
