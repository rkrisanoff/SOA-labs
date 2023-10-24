package ifmo.drukhary.StudyGroupsApp.repositories;

import ifmo.drukhary.StudyGroupsApp.DTO.Filter;
import ifmo.drukhary.StudyGroupsApp.entities.CoordinatesEntity;
import ifmo.drukhary.StudyGroupsApp.entities.StudyGroupEntity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface StudyGroupRepo {

    public List<StudyGroupEntity> getAll(List<Filter> filters, int offset, int limit);
    public Optional<StudyGroupEntity> getById(int id);
    public Optional<StudyGroupEntity> create(StudyGroupEntity studyGroup);

    public int updateById(int id, StudyGroupEntity studyGroup);

    public boolean deleteById(int id);

}
