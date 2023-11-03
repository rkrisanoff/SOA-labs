package ifmo.drukhary.StudyGroupsApp.utils;

public class Constaints {
    public final static String STUDY_GROUP_VALIDATION_EXPRESSION = "(id|name|coordinates.x|coordinates.y|creationDate|studentsCount|" +
            "shouldBeExpelled|formOfEducation|semesterEnum|groupAdmin.name|" +
            "groupAdmin.passportID|groupAdmin.nationality|groupAdmin.location.x|" +
            "groupAdmin.location.y|groupAdmin.location.z):.+";
}
