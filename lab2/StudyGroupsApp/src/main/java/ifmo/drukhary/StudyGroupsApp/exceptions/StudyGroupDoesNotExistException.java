package ifmo.drukhary.StudyGroupsApp.exceptions;

import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudyGroupDoesNotExistException extends NotFoundException {
    final int id;
}
