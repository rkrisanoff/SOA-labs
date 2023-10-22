package ifmo.drukhary.StudyGroupsApp.DTO;

import ifmo.drukhary.StudyGroupsApp.entities.LocationEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Data
public class Person {
    private String name;
    private String passportID;
    private String nationality;
    private Location location;
}
