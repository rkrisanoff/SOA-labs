package ifmo.drukhary.StudyGroupsApp.repositories;

import ifmo.drukhary.StudyGroupsApp.DTO.Filter;
import ifmo.drukhary.StudyGroupsApp.entities.StudyGroupEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Stateless
public class StudyGroupRepoImpl implements StudyGroupRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<StudyGroupEntity> getAll(List<Filter> filters, List<String> sorts,int offset, int limit) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudyGroupEntity> criteriaQuery
                = criteriaBuilder.createQuery(StudyGroupEntity.class);

        Root<StudyGroupEntity> studyGroups
                = criteriaQuery.from(StudyGroupEntity.class);
        Predicate[] predicates = filters.stream()
                .collect(Collectors.groupingBy(Filter::attributeName))
                .entrySet().stream()
                .map(filtersByAttribute -> criteriaBuilder.or(
                                filtersByAttribute.getValue().stream()
                                        .map(filter -> criteriaBuilder.equal(
                                                getExpressionByFieldName(studyGroups, filtersByAttribute.getKey()),
                                                filter.attributeValue()
                                        )).toArray(Predicate[]::new)
                        )
                ).toArray(Predicate[]::new);

        if (sorts == null || sorts.isEmpty()) {
            sorts = List.of("id");
        }

        criteriaQuery.select(studyGroups).orderBy(
                sorts.stream().toList().stream().map(sort -> {
                    if (sort.startsWith("-")){
                        return criteriaBuilder.desc(getExpressionByFieldName(studyGroups,sort.substring(1)));
                    } else {
                        return criteriaBuilder.asc(getExpressionByFieldName(studyGroups,sort));
                    }
                }).toArray(Order[]::new)
        ).where(criteriaBuilder.and(predicates));

        return entityManager
                .createQuery(criteriaQuery)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();

    }

    private static<T> Expression<?> getExpressionByFieldName(Root<T> root, String attributeName) {
        if (attributeName.contains(".")) {
            String[] parts = attributeName.split("[.]");

            Path<?> childrenRoot = root;

            for (String attr: parts) {
                if (attr.isBlank())
                    throw new RuntimeException("Attribute cannot be blank string");
                else
                    childrenRoot = childrenRoot.get(attr);
            }

            return childrenRoot;
        }

        return root.get(attributeName);
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
                if (studyGroup.getCreationDate() == null)
                    studyGroup.setCreationDate(java.time.LocalDate.now());

                entityManager.persist(studyGroup);

                StudyGroupEntity result = entityManager.merge(studyGroup);
                return Optional.ofNullable(result);
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
