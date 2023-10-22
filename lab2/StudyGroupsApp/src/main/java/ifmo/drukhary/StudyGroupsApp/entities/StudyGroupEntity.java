package ifmo.drukhary.StudyGroupsApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "study_groups", schema = "", catalog = "")
public class StudyGroupEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Setter

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;
    @Setter

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coordinates_id", nullable = false, referencedColumnName = "id")
    private CoordinatesEntity coordinates;
    @Setter

    @Basic
    @Column(name = "creationDate", nullable = false)
    private java.time.LocalDate creationDate;
    @Setter

    @Basic
    @Column(name = "studentsCount", nullable = true)
    private Long studentsCount;
    @Setter

    @Basic
    @Column(name = "shouldBeExpelled", nullable = false)
    private int shouldBeExpelled;
    @Setter

    @Basic
    @Column(name = "formOfEducation", nullable = false)
    private String formOfEducation;
    @Setter

    @Basic
    @Column(name = "semesterEnum", nullable = true)
    private String semesterEnum;
    @Setter

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "groupAdmin_id", nullable = false, referencedColumnName = "id")
    private PersonEntity groupAdmin;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudyGroupEntity that = (StudyGroupEntity) o;
        return id == that.id && shouldBeExpelled == that.shouldBeExpelled && Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates) && Objects.equals(creationDate, that.creationDate) && Objects.equals(studentsCount, that.studentsCount) && Objects.equals(formOfEducation, that.formOfEducation) && Objects.equals(semesterEnum, that.semesterEnum) && Objects.equals(groupAdmin, that.groupAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, studentsCount, shouldBeExpelled, formOfEducation, semesterEnum, groupAdmin);
    }
}
