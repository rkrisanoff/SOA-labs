package ifmo.drukhary.StudyGroupsApp.services;

import ifmo.drukhary.StudyGroupsApp.DTO.Filter;
import ifmo.drukhary.StudyGroupsApp.DTO.StudyGroupBase;
import ifmo.drukhary.StudyGroupsApp.entities.CoordinatesEntity;
import ifmo.drukhary.StudyGroupsApp.entities.LocationEntity;
import ifmo.drukhary.StudyGroupsApp.entities.PersonEntity;
import ifmo.drukhary.StudyGroupsApp.entities.StudyGroupEntity;
import ifmo.drukhary.StudyGroupsApp.exceptions.StudyGroupDoesNotExistException;
import ifmo.drukhary.StudyGroupsApp.exceptions.WrongFilterException;
import ifmo.drukhary.StudyGroupsApp.repositories.StudyGroupRepo;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static ifmo.drukhary.StudyGroupsApp.utils.Constants.STUDY_GROUP_VALIDATION_EXPRESSION;

@Stateless
public class StudyGroupServiceImpl implements StudyGroupService {

    @EJB
    private StudyGroupRepo studyGroupRepo;

    @PostConstruct
    public void init() {
    }


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Optional<StudyGroupEntity> getById(int id) {
        return studyGroupRepo.getById(id);
    }

    @Override
    @Transactional
    public StudyGroupEntity updateById(int id, StudyGroupBase studyGroup) throws StudyGroupDoesNotExistException {
        Optional<StudyGroupEntity> maybeStudyGroup = studyGroupRepo.getById(id);
        if (maybeStudyGroup.isPresent()) {
            StudyGroupEntity studyGroupEntity = this.dataToEntity(studyGroup);
            studyGroupEntity.setId(id);
            studyGroupEntity.setCreationDate(maybeStudyGroup.get().getCreationDate());
            entityManager.merge(studyGroupEntity);
            return studyGroupEntity;
        }
        throw new NotFoundException();
    }

    @Override
    @Transactional
    public void deleteById(int id) throws StudyGroupDoesNotExistException {
        studyGroupRepo.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<StudyGroupEntity> create(StudyGroupBase studyGroup) {
        StudyGroupEntity studyGroupEntity = this.dataToEntity(studyGroup);

        return studyGroupRepo.create(studyGroupEntity);
    }

    @Override
    @Transactional
    public List<StudyGroupEntity> getAll(List<String> rawFilters, List<String> sorts, int page, int size) throws WrongFilterException {

        for (String rawFilter : rawFilters) {
            if (!rawFilter.matches(STUDY_GROUP_VALIDATION_EXPRESSION)) {
                throw new WrongFilterException(rawFilter);
            }
        }

        List<Filter> filters = rawFilters.stream().map(filter -> {
            String[] parts = filter.split(":");
            return new Filter(parts[0], parts[1]);
        }).toList();

        return studyGroupRepo.getAll(filters, sorts,(page-1) * size, size);
    }


    @Override
    @Transactional
    public long getAllStudentCount(){
        Long allStudentCount = studyGroupRepo.getAllStudentCount();
        if (allStudentCount == null){
            return 0L;
        }

        return allStudentCount;
    }

    @Override
    @Transactional
    public List<StudyGroupEntity> getAllWithNameStartWith(String name) {
        return studyGroupRepo.getAllWithNameStartWith(name);
    }

    @Override
    @Transactional
    public int deleteAllByStudentCount(long studentCount) {
        return studyGroupRepo.deleteAllByStudentCount(studentCount);
    }


    private StudyGroupEntity dataToEntity(StudyGroupBase studyGroup) {
        LocationEntity locationEntity = new LocationEntity();
        CoordinatesEntity coordinatesEntity = new CoordinatesEntity();
        PersonEntity personEntity = new PersonEntity();
        StudyGroupEntity studyGroupEntity = new StudyGroupEntity();

        personEntity.setLocation(locationEntity);
        studyGroupEntity.setGroupAdmin(personEntity);
        studyGroupEntity.setCoordinates(coordinatesEntity);

        studyGroupEntity.setName(studyGroup.getName());
        studyGroupEntity.setSemesterEnum(studyGroup.getSemesterEnum());
        studyGroupEntity.setStudentsCount(studyGroup.getStudentsCount());
        studyGroupEntity.setFormOfEducation(studyGroup.getFormOfEducation());
        studyGroupEntity.setShouldBeExpelled(studyGroup.getShouldBeExpelled());
        studyGroupEntity.setCreationDate(LocalDate.now());



        personEntity.setName(studyGroup.getGroupAdmin().getName());
        personEntity.setNationality(studyGroup.getGroupAdmin().getNationality());
        personEntity.setPassportID(studyGroup.getGroupAdmin().getPassportID());

        locationEntity.setX(studyGroup.getGroupAdmin().getLocation().getX());
        locationEntity.setY(studyGroup.getGroupAdmin().getLocation().getY());
        locationEntity.setZ(studyGroup.getGroupAdmin().getLocation().getZ());

        coordinatesEntity.setX(studyGroup.getCoordinates().getX());
        coordinatesEntity.setY(studyGroup.getCoordinates().getY());

        return studyGroupEntity;
    }
}
