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
@Table(name = "persons", schema = "", catalog = "")
public class PersonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Setter

    @Basic
    @Column(name = "name", nullable = false, length = 64)
    private String name;
    @Setter

    @Basic
    @Column(name = "passportID", nullable = false, length = 64)
    private String passportID;
    @Setter

    @Basic
    @Column(name = "nationality", nullable = true)
    private String nationality;

    @Setter

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", nullable = false, referencedColumnName = "id")
    private LocationEntity location;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity that = (PersonEntity) o;
        return Objects.equals(name, that.name) && Objects.equals(passportID, that.passportID) && Objects.equals(nationality, that.nationality) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passportID, nationality, location);
    }
}
