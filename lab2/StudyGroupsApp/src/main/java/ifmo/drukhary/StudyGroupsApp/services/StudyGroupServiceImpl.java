package ifmo.drukhary.StudyGroupsApp.services;

import ifmo.drukhary.StudyGroupsApp.DTO.Filter;
import ifmo.drukhary.StudyGroupsApp.DTO.StudyGroupBase;
import ifmo.drukhary.StudyGroupsApp.entities.CoordinatesEntity;
import ifmo.drukhary.StudyGroupsApp.entities.LocationEntity;
import ifmo.drukhary.StudyGroupsApp.entities.PersonEntity;
import ifmo.drukhary.StudyGroupsApp.entities.StudyGroupEntity;
import ifmo.drukhary.StudyGroupsApp.exceptions.StudyGroupDoesntExistException;
import ifmo.drukhary.StudyGroupsApp.repositories.StudyGroupRepo;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Stateless
public class StudyGroupServiceImpl implements StudyGroupService {

    @EJB
    private StudyGroupRepo studyGroupRepo;

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<StudyGroupEntity> getById(int id) {
        return studyGroupRepo.getById(id);
    }

    @Override
    @Transactional
    public StudyGroupEntity updateById(int id, StudyGroupBase studyGroup) throws StudyGroupDoesntExistException {
        Optional<StudyGroupEntity> maybeStudyGroup = studyGroupRepo.getById(id);
        if (maybeStudyGroup.isPresent()) {
            StudyGroupEntity studyGroupEntity = this.dataToEntity(studyGroup);
            studyGroupEntity.setId(id);
            entityManager.merge(studyGroupEntity);
            return studyGroupEntity;
        }
        throw new StudyGroupDoesntExistException();
    }

    @Override
    @Transactional
    public void deleteById(int id) throws StudyGroupDoesntExistException {
        Optional<StudyGroupEntity> maybeStudyGroup = studyGroupRepo.getById(id);
        if (maybeStudyGroup.isPresent()) {
            entityManager.remove(maybeStudyGroup.get());
            return;
        }
        throw new StudyGroupDoesntExistException();
    }

    @Override
    @Transactional
    public Optional<StudyGroupEntity> create(StudyGroupBase studyGroup) {
        StudyGroupEntity studyGroupEntity = this.dataToEntity(studyGroup);

        return studyGroupRepo.create(studyGroupEntity);
    }

    @Override
    @Transactional
    public List<StudyGroupEntity> getAll(List<String> rawFilters, List<String> sorts, int page, int size) {
//        List<Filter> filters = List.of(
//                new Filter("name", "name2", "3")
////                new Filter("name","name2","6")
////                new Filter("id",1,"9")
//        );
        List<Filter> filters = rawFilters.stream().map(filter -> {
            String[] parts = filter.split(":");
            return new Filter(parts[0], parts[1]);
        }).toList();

        return studyGroupRepo.getAll(filters, sorts,(page-1) * size, size);
    }

    private StudyGroupEntity dataToEntity(StudyGroupBase studyGroup) {
        LocationEntity locationEntity = new LocationEntity();
        CoordinatesEntity coordinatesEntity = new CoordinatesEntity();
        PersonEntity personEntity = new PersonEntity();
        StudyGroupEntity studyGroupEntity = new StudyGroupEntity();

        studyGroupEntity.setName(studyGroup.getName());
        studyGroupEntity.setSemesterEnum(studyGroup.getSemesterEnum());
        studyGroupEntity.setStudentsCount(studyGroup.getStudentsCount());
        studyGroupEntity.setFormOfEducation(studyGroup.getFormOfEducation());
        studyGroupEntity.setShouldBeExpelled(studyGroup.getShouldBeExpelled());
        studyGroupEntity.setCreationDate(LocalDate.now());

        studyGroupEntity.setGroupAdmin(personEntity);
        studyGroupEntity.setCoordinates(coordinatesEntity);

        personEntity.setName(studyGroup.getGroupAdmin().getName());
        personEntity.setNationality(studyGroup.getGroupAdmin().getNationality());
        personEntity.setPassportID(studyGroup.getGroupAdmin().getPassportID());
        personEntity.setLocation(locationEntity);

        locationEntity.setX(studyGroup.getGroupAdmin().getLocation().getX());
        locationEntity.setY(studyGroup.getGroupAdmin().getLocation().getY());
        locationEntity.setZ(studyGroup.getGroupAdmin().getLocation().getZ());

        coordinatesEntity.setX(studyGroup.getCoordinates().getX());
        coordinatesEntity.setY(studyGroup.getCoordinates().getY());

        return studyGroupEntity;
    }
}
