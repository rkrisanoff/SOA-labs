package ifmo.drukhary.StudyGroupsApp.DTO;

import ifmo.drukhary.StudyGroupsApp.entities.CoordinatesEntity;
import ifmo.drukhary.StudyGroupsApp.entities.PersonEntity;
import jakarta.persistence.*;
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
