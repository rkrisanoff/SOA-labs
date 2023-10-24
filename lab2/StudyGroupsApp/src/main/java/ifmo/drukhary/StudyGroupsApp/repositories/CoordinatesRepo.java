package ifmo.drukhary.StudyGroupsApp.repositories;

import ifmo.drukhary.StudyGroupsApp.entities.CoordinatesEntity;

import java.util.List;

public interface CoordinatesRepo  {

    public List<CoordinatesEntity> getAll();
    public CoordinatesEntity getById(long id);
    public long create(CoordinatesEntity coordinates);

}
