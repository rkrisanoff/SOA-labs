package ifmo.drukhary.StudyGroupsApp.entities;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "study_groups")
public class StudyGroupEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coordinates_id", nullable = false, referencedColumnName = "id")
    private CoordinatesEntity coordinates;

    @Basic
    @Column(name = "creationDate", nullable = false)
//    @JsonbDateFormat("yyyy-MM-ddT00:00:00Z")
    private java.time.LocalDate creationDate;

    @Basic
    @Column(name = "studentsCount", nullable = true)
    private Long studentsCount;

    @Basic
    @Column(name = "shouldBeExpelled", nullable = false)
    private int shouldBeExpelled;

    @Basic
    @Column(name = "formOfEducation", nullable = false)
    private String formOfEducation;

    @Basic
    @Column(name = "semesterEnum", nullable = true)
    private String semesterEnum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "groupAdmin_id", nullable = false, referencedColumnName = "id")
    private PersonEntity groupAdmin;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        StudyGroupEntity that = (StudyGroupEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
