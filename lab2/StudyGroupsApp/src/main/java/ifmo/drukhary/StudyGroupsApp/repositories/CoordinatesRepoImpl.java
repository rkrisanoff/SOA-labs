package ifmo.drukhary.StudyGroupsApp.repositories;

import ifmo.drukhary.StudyGroupsApp.entities.CoordinatesEntity;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

@Stateless
public class CoordinatesRepoImpl implements CoordinatesRepo{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<CoordinatesEntity> getAll() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<CoordinatesEntity> criteriaQuery = cb.createQuery(CoordinatesEntity.class);
        Root<CoordinatesEntity> from = criteriaQuery.from(CoordinatesEntity.class);

        criteriaQuery.select(from);
        TypedQuery<CoordinatesEntity> query = entityManager.createQuery(criteriaQuery);
        List<CoordinatesEntity> coordinatesList = query.getResultList();
        return coordinatesList;
    }

    @Override
    public CoordinatesEntity getById(long id) {
        return null;
    }

    @Override
    public long create(CoordinatesEntity coordinates) {
        return 0;
    }
}