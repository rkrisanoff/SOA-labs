package ifmo.drukhary.StudyGroupsApp.services;

import ifmo.drukhary.StudyGroupsApp.DTO.StudyGroupBase;
import ifmo.drukhary.StudyGroupsApp.entities.StudyGroupEntity;
import ifmo.drukhary.StudyGroupsApp.exceptions.StudyGroupDoesntExistException;

import java.util.List;
import java.util.Optional;

public interface StudyGroupService {

     Optional<StudyGroupEntity> getById(int id);
    StudyGroupEntity updateById(int id, StudyGroupBase studyGroup) throws StudyGroupDoesntExistException;
    void deleteById(int id) throws StudyGroupDoesntExistException;
    Optional<StudyGroupEntity> create(StudyGroupBase studyGroup);

    List<StudyGroupEntity> getAll(List<String> filters, List<String> sorts, int size, int page);
}
