package ifmo.drukhary.StudyGroupsApp.controllers;

import ifmo.drukhary.StudyGroupsApp.DTO.StudyGroupBase;
import ifmo.drukhary.StudyGroupsApp.entities.StudyGroupEntity;
import ifmo.drukhary.StudyGroupsApp.exceptions.StudyGroupDoesntExist;
import ifmo.drukhary.StudyGroupsApp.services.StudyGroupService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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
    public List<StudyGroupEntity> getStudyGroups() {
        return studyGroupService.getAll();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}/")
    public Response deleteStudyGroup(@PathParam("id") int id) throws StudyGroupDoesntExist {
        studyGroupService.deleteById(id);
        return Response.ok("ok").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/")
    public Response updateStudyGroup(@PathParam("id") int id, StudyGroupBase studyGroup) throws StudyGroupDoesntExist {
        StudyGroupEntity updatedStudyGroup =  studyGroupService.updateById(id, studyGroup);
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
