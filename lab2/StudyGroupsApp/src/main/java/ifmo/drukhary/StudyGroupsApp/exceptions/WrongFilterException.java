package ifmo.drukhary.StudyGroupsApp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WrongFilterException extends Exception{
    final String value;
}
