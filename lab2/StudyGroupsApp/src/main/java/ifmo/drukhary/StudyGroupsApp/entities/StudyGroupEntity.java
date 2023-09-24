//package ifmo.drukhary.StudyGroupsApp.entities;
//
//import jakarta.persistence.*;
//
//import java.io.Serializable;
//import java.sql.Date;
//import java.util.Objects;
//
//@Entity
//@Table(name = "StudyGroup", schema = "", catalog = "")
//public class StudyGroupEntity implements Serializable {
//    private int id;
//    private String name;
//    private CoordinatesEntity coordinates;
//    private Date creationDate;
//    private Long studentsCount;
//    private int shouldBeExpelled;
//    private String formOfEducation;
//    private String semesterEnum;
//    private PersonEntity groupAdmin;
//
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "id", nullable = false)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "name", nullable = false, length = -1)
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Basic
//    @Column(name = "coordinates", nullable = false)
//    public CoordinatesEntity getCoordinates() {
//        return coordinates;
//    }
//
//    public void setCoordinates(CoordinatesEntity coordinates) {
//        this.coordinates = coordinates;
//    }
//
//    @Basic
//    @Column(name = "creationDate", nullable = false)
//    public Date getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(Date creationDate) {
//        this.creationDate = creationDate;
//    }
//
//    @Basic
//    @Column(name = "studentsCount", nullable = true)
//    public Long getStudentsCount() {
//        return studentsCount;
//    }
//
//    public void setStudentsCount(Long studentsCount) {
//        this.studentsCount = studentsCount;
//    }
//
//    @Basic
//    @Column(name = "shouldBeExpelled", nullable = false)
//    public int getShouldBeExpelled() {
//        return shouldBeExpelled;
//    }
//
//    public void setShouldBeExpelled(int shouldBeExpelled) {
//        this.shouldBeExpelled = shouldBeExpelled;
//    }
//
//    @Basic
//    @Column(name = "formOfEducation", nullable = false)
//    public Object getFormOfEducation() {
//        return formOfEducation;
//    }
//
//    public void setFormOfEducation(Object formOfEducation) {
//        this.formOfEducation = formOfEducation;
//    }
//
//    @Basic
//    @Column(name = "semesterEnum", nullable = true)
//    public Object getSemesterEnum() {
//        return semesterEnum;
//    }
//
//    public void setSemesterEnum(Object semesterEnum) {
//        this.semesterEnum = semesterEnum;
//    }
//
//    @Basic
//    @Column(name = "groupAdmin", nullable = false)
//    public Object getGroupAdmin() {
//        return groupAdmin;
//    }
//
//    public void setGroupAdmin(Object groupAdmin) {
//        this.groupAdmin = groupAdmin;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        StudyGroupEntity that = (StudyGroupEntity) o;
//        return id == that.id && shouldBeExpelled == that.shouldBeExpelled && Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates) && Objects.equals(creationDate, that.creationDate) && Objects.equals(studentsCount, that.studentsCount) && Objects.equals(formOfEducation, that.formOfEducation) && Objects.equals(semesterEnum, that.semesterEnum) && Objects.equals(groupAdmin, that.groupAdmin);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, coordinates, creationDate, studentsCount, shouldBeExpelled, formOfEducation, semesterEnum, groupAdmin);
//    }
//}
