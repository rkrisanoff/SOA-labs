//package ifmo.drukhary.StudyGroupsApp.services;
//
//import ifmo.drukhary.StudyGroupsApp.repositories.CoordinatesRepo;
//import jakarta.annotation.PostConstruct;
//import jakarta.enterprise.context.Dependent;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
//import org.springframework.data.repository.core.support.RepositoryFactorySupport;
//
//import javax.ejb.Stateless;
//
//@Stateless
//public class FuckService {
//
//    @jakarta.enterprise.inject.Produces
//    @Dependent
//    @PersistenceContext
//    private EntityManager entityManager;
//    private CoordinatesRepo coordinatesRepo;
//
//    @PostConstruct
//    private void init() {
//        RepositoryFactorySupport factory = new JpaRepositoryFactory(entityManager);
//        this.coordinatesRepo = factory.getRepository(CoordinatesRepo.class);
//    }
//
//
//    public CoordinatesRepo getCoordinatesRepo() {
//        return this.coordinatesRepo;
//    }
//}
