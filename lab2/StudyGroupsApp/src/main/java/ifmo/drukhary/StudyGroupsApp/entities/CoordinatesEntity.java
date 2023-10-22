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
@Table(name = "Coordinates", schema = "", catalog = "")
public class CoordinatesEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Setter
    private Double x;

    @Setter
    private double y;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinatesEntity that = (CoordinatesEntity) o;
        return Double.compare(y, that.y) == 0 && Objects.equals(x, that.x) && (long) id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, x, y);
    }
}
