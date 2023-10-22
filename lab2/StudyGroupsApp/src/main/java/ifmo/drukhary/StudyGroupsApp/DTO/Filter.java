package ifmo.drukhary.StudyGroupsApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

//@AllArgsConstructor
//@Getter
public record Filter(String attributeName, Object attributeValue, String condition){}
