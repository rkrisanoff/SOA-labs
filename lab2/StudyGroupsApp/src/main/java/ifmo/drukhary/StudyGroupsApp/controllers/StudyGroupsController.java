package ifmo.drukhary.StudyGroupsApp.controllers;

import ifmo.drukhary.StudyGroupsApp.entities.CoordinatesEntity;
//import ifmo.drukhary.StudyGroupsApp.entities.StudyGroupEntity;
//import ifmo.drukhary.StudyGroupsApp.repositories.CoordinatesRepo;
//import ifmo.drukhary.StudyGroupsApp.services.FuckService;
import ifmo.drukhary.StudyGroupsApp.utils.HibernateUtil;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.inject.Inject;
import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/study-groups")
public class StudyGroupsController {
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("{id}")
//    public String GetStudyGroup() {
////        entityManager.find();
//        return "Hello, World!";
//    }

//    @jakarta.enterprise.inject.Produces
//    @Dependent
//    @PersistenceContext
//    private EntityManager entityManager;
    @GET
    @jakarta.ws.rs.Produces(APPLICATION_JSON)
    public int getStudyGroups() {
//        HibernateUtils.getHibernateQuery();
//        HibernateUtils.getHibernateQuery()
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<CoordinatesEntity> cr = cb.createQuery(CoordinatesEntity.class);
        Root<CoordinatesEntity> root = cr.from(CoordinatesEntity.class);
        cr.select(root);

        Query<CoordinatesEntity> query = session.createQuery(cr);
        List<CoordinatesEntity> results = query.getResultList();
        return 0;
//        return entityManager.find(CoordinatesEntity.class, Long.parseLong("3"));
    }

//    @DELETE
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("{id}")
//    public Response deleteStudyGroup(Long id) {
////        StudyGroupEntity studyGroup = entityManager.find(StudyGroupEntity.class,id);
////        if (studyGroup == null){
////            return Response.serverError().build();
////        }
////        entityManager.remove(studyGroup);
//        return Response.ok("ok").build();

//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public String updateStudyGroup() {
//        return "Hello, World!";
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public String createStudyGroup() {
//        return "Hello, World!";
//    }
}
