//package ifmo.drukhary.StudyGroupsApp.entities;
//
//import jakarta.persistence.*;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//@Entity
//@Table(name = "LOCATION", schema = "", catalog = "")
//public class LocationEntity implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    private Double x;
//    private long y;
//    private double z;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "x", nullable = true, precision = 0)
//    public Double getX() {
//        return x;
//    }
//
//    public void setX(Double x) {
//        this.x = x;
//    }
//
//    @Basic
//    @Column(name = "y", nullable = false)
//    public long getY() {
//        return y;
//    }
//
//    public void setY(long y) {
//        this.y = y;
//    }
//
//    @Basic
//    @Column(name = "z", nullable = false, precision = 0)
//    public double getZ() {
//        return z;
//    }
//
//    public void setZ(double z) {
//        this.z = z;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        LocationEntity that = (LocationEntity) o;
//        return y == that.y && Double.compare(z, that.z) == 0 && Objects.equals(x, that.x);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(x, y, z);
//    }
//}
