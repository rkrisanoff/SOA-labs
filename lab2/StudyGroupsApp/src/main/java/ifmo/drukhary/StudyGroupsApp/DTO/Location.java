package ifmo.drukhary.StudyGroupsApp.DTO;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.Setter;

@Data
public class Location {
    private Double x;
    private long y;
    private double z;
}
