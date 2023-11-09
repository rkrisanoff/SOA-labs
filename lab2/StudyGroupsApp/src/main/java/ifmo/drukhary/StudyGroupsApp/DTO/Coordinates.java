package ifmo.drukhary.StudyGroupsApp.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Setter;

@Data
public class Coordinates {
    private Float x;
    @NotNull(message="y must be not null")
    private Float y; //Поле не может быть null
}
