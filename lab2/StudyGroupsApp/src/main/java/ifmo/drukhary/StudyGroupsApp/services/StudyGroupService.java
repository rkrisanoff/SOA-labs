package ifmo.drukhary.StudyGroupsApp.services;

import ifmo.drukhary.StudyGroupsApp.DTO.StudyGroupBase;
import ifmo.drukhary.StudyGroupsApp.entities.StudyGroupEntity;
import ifmo.drukhary.StudyGroupsApp.exceptions.StudyGroupDoesntExist;

import java.util.List;
import java.util.Optional;

public interface StudyGroupService {

    public  Optional<StudyGroupEntity> getById(int id);
    public StudyGroupEntity updateById(int id, StudyGroupBase studyGroup) throws StudyGroupDoesntExist;
    public void deleteById(int id) throws StudyGroupDoesntExist;
    public Optional<StudyGroupEntity> create(StudyGroupBase studyGroup);

    public List<StudyGroupEntity> getAll();
}
