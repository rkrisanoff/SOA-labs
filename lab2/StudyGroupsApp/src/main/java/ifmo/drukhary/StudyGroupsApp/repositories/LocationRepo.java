package ifmo.drukhary.StudyGroupsApp.repositories;

import ifmo.drukhary.StudyGroupsApp.entities.LocationEntity;

import java.util.List;

public interface LocationRepo  {

    public List<LocationEntity> getAll();
    public LocationEntity getById(long id);
    public long create(LocationEntity location);

}
