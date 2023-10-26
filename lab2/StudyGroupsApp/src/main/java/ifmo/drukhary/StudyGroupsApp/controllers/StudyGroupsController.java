package ifmo.drukhary.StudyGroupsApp.controllers;

import ifmo.drukhary.StudyGroupsApp.DTO.StudyGroupBase;
import ifmo.drukhary.StudyGroupsApp.entities.StudyGroupEntity;
import ifmo.drukhary.StudyGroupsApp.exceptions.StudyGroupDoesntExistException;
import ifmo.drukhary.StudyGroupsApp.services.StudyGroupService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import jakarta.inject.Qualifier;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/study-groups")
@Stateless
public class StudyGroupsController {

    @EJB
    private StudyGroupService studyGroupService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/")
    public Response GetStudyGroup(@PathParam("id") int id) {
        Optional<StudyGroupEntity> maybeStudyGroup = studyGroupService.getById(id);
        if (maybeStudyGroup.isPresent()) {
            return Response.ok(maybeStudyGroup.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces(APPLICATION_JSON)
    public List<StudyGroupEntity> getStudyGroups(
            @QueryParam("filter") List<String> filters,
            @QueryParam("sort")  List<String> sorts,
            @QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("size") @DefaultValue("25") int size
    ) {
//        if (filters == null){
//            filters = List.of();
//        }
//        if (sorts == null){
//            sorts = List.of();
//        }
        return studyGroupService.getAll(filters,sorts,page,size);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}/")
    public Response deleteStudyGroup(@PathParam("id") int id) throws StudyGroupDoesntExistException {
        studyGroupService.deleteById(id);
        return Response.ok("ok").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/")
    public Response updateStudyGroup(@PathParam("id") int id, StudyGroupBase studyGroup) throws StudyGroupDoesntExistException {
        StudyGroupEntity updatedStudyGroup = studyGroupService.updateById(id, studyGroup);
        return Response.ok().entity(updatedStudyGroup).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createStudyGroup(StudyGroupBase studyGroup) {
        studyGroupService.create(studyGroup);
        return "Hello, World!";
    }

}
