package ifmo.drukhary.StudyGroupsApp.repositories;

import ifmo.drukhary.StudyGroupsApp.DTO.Filter;
import ifmo.drukhary.StudyGroupsApp.entities.CoordinatesEntity;
import ifmo.drukhary.StudyGroupsApp.entities.StudyGroupEntity;
import ifmo.drukhary.StudyGroupsApp.exceptions.StudyGroupDoesNotExistException;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface StudyGroupRepo {

    public List<StudyGroupEntity> getAll(List<Filter> filters, List<String> sorts, int offset, int limit);
    public Optional<StudyGroupEntity> getById(int id);
    public Optional<StudyGroupEntity> create(StudyGroupEntity studyGroup);

    public int updateById(int id, StudyGroupEntity studyGroup);

    public void deleteById(int id) throws StudyGroupDoesNotExistException;

    // Extra functions

    public Long getAllStudentCount();

    public List<StudyGroupEntity> getAllWithNameStartWith(String name);


    public int deleteAllByStudentCount(long studentCount);




}
