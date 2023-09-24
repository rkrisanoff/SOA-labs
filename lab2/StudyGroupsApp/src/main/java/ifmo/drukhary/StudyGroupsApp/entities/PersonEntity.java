//package ifmo.drukhary.StudyGroupsApp.entities;
//
//import jakarta.persistence.Basic;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//@Entity
//@Table(name = "PERSON", schema = "", catalog = "")
//public class PersonEntity implements Serializable  {
//    private String name;
//    private String passportId;
//    private String nationality;
//    private String location;
//
//    @Basic
//    @Column(name = "name", nullable = false, length = 64)
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Basic
//    @Column(name = "passportID", nullable = false, length = 64)
//    public String getPassportId() {
//        return passportId;
//    }
//
//    public void setPassportId(String passportId) {
//        this.passportId = passportId;
//    }
//
//    @Basic
//    @Column(name = "nationality", nullable = true)
//    public String getNationality() {
//        return nationality;
//    }
//
//    public void setNationality(String nationality) {
//        this.nationality = nationality;
//    }
//
//    @Basic
//    @Column(name = "location", nullable = false)
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PersonEntity that = (PersonEntity) o;
//        return Objects.equals(name, that.name) && Objects.equals(passportId, that.passportId) && Objects.equals(nationality, that.nationality) && Objects.equals(location, that.location);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, passportId, nationality, location);
//    }
//}
