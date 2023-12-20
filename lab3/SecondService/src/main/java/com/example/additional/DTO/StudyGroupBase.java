package com.example.additional.DTO;


import lombok.Data;
import lombok.Setter;
@Data
public class StudyGroupBase {
    private String name;
    private Coordinates coordinates;
    private java.time.LocalDate creationDate;
    private Long studentsCount;
    private int shouldBeExpelled;
    private String formOfEducation;
    private String semesterEnum;
    private Person groupAdmin;
}
