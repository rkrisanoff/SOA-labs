package ifmo.drukhary.StudyGroupsApp.repositories;

import ifmo.drukhary.StudyGroupsApp.DTO.Filter;
import ifmo.drukhary.StudyGroupsApp.entities.StudyGroupEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Stateless
public class StudyGroupRepoImpl implements StudyGroupRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<StudyGroupEntity> getAll(List<Filter> filters, int offset, int limit) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudyGroupEntity> criteriaQuery
                = criteriaBuilder.createQuery(StudyGroupEntity.class);

        Root<StudyGroupEntity> studyGroups
                = criteriaQuery.from(StudyGroupEntity.class);
        Predicate[] predicates = filters.stream()
//                .reduce(new HashMap<String[],Filter[]>(), (HashMap<String[],List<Filter>> acc, Filter filter)->{
//                    acc.containsKey(filter.attributeName())
//                    acc.put(filter.attributeName(),);
//                })
                .collect(Collectors.groupingBy(Filter::attributeName))
                .entrySet().stream()
                .map(filtersByAttribute -> criteriaBuilder.or(
                                filtersByAttribute.getValue().stream()
                                        .map(filter -> criteriaBuilder.equal(
                                                studyGroups.get(filtersByAttribute.getKey()),
                                                filter.attributeValue()
                                        )).toArray(Predicate[]::new)
                        )
                ).toArray(Predicate[]::new);
        criteriaQuery.select(studyGroups);
//                .where(criteriaBuilder.and(predicates));
//                .where(criteriaBuilder.equal(studyGroups.get("coordinates").get("x"),3));

        return entityManager
                .createQuery(criteriaQuery)
                .setFirstResult(offset)
                .setMaxResults(50)
                .getResultList();


//
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
//        Root<Employee> employee = query.from(Employee.class);
//        Join<Employee, Department> department = employee.join("department");
//        query.select(employee).where(cb.equal(department.get("name"), "IT"));
//        List<Employee> employees = entityManager.createQuery(query).getResultList();


//        TypedQuery<StudyGroupEntity> query = entityManager.createQuery(criteriaQuery);
//        List<StudyGroupEntity> coordinatesList = query.getResultList();
//        return coordinatesList;
    }

    @Override
    @Transactional
    public Optional<StudyGroupEntity> getById(int id) {
        return Optional.ofNullable(entityManager.find(StudyGroupEntity.class, id));
    }

    @Override
    @Transactional
    public Optional<StudyGroupEntity> create(StudyGroupEntity studyGroup) {
        if (studyGroup != null) {
            if (entityManager.find(StudyGroupEntity.class, studyGroup.getId()) == null) {
                if (studyGroup.getCreationDate() == null)
                    studyGroup.setCreationDate(java.time.LocalDate.now());

                entityManager.persist(studyGroup);

                StudyGroupEntity result = entityManager.merge(studyGroup);
                return Optional.ofNullable(result);
            }
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public int updateById(int id, StudyGroupEntity studyGroup) {
        if (studyGroup != null) {
            if (entityManager.find(StudyGroupEntity.class, studyGroup.getId()) != null) {
                if (studyGroup.getCreationDate() == null)
                    studyGroup.setCreationDate(LocalDate.now());
                entityManager.merge(studyGroup);
            }
        }
        return 1;
    }

    @Override
    @Transactional
    public boolean deleteById(int id) {
        return false;
    }
}
