package ifmo.drukhary.StudyGroupsApp.services;

import ifmo.drukhary.StudyGroupsApp.DTO.StudyGroupBase;
import ifmo.drukhary.StudyGroupsApp.entities.StudyGroupEntity;
import ifmo.drukhary.StudyGroupsApp.exceptions.StudyGroupDoesNotExistException;
import ifmo.drukhary.StudyGroupsApp.exceptions.WrongFilterException;

import java.util.List;
import java.util.Optional;

public interface StudyGroupService {

    Optional<StudyGroupEntity> getById(int id);

    StudyGroupEntity updateById(int id, StudyGroupBase studyGroup) throws StudyGroupDoesNotExistException;

    void deleteById(int id) throws StudyGroupDoesNotExistException;

    Optional<StudyGroupEntity> create(StudyGroupBase studyGroup);

    List<StudyGroupEntity> getAll(List<String> filters, List<String> sorts, int size, int page) throws WrongFilterException;

    // Extra functions

    public long getAllStudentCount();

    public List<StudyGroupEntity> getAllWithNameStartWith(String name);


    public int deleteAllByStudentCount(long studentCount);
}
