package ifmo.drukhary.StudyGroupsApp.controllers;

import ifmo.drukhary.StudyGroupsApp.DTO.StudyGroupBase;
import ifmo.drukhary.StudyGroupsApp.DTO.responses.DeleteAllByStudentCountResponse;
import ifmo.drukhary.StudyGroupsApp.DTO.responses.GetAllStudentsCountResponse;
import ifmo.drukhary.StudyGroupsApp.entities.StudyGroupEntity;
import ifmo.drukhary.StudyGroupsApp.exceptions.StudyGroupDoesNotExistException;
import ifmo.drukhary.StudyGroupsApp.exceptions.WrongFilterException;
import ifmo.drukhary.StudyGroupsApp.services.StudyGroupService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    public Response GetStudyGroup(@PathParam("id") @Positive(message = "id must be positive") int id)
            throws StudyGroupDoesNotExistException {
        Optional<StudyGroupEntity> maybeStudyGroup = studyGroupService.getById(id);
        if (maybeStudyGroup.isEmpty()) {
            throw new StudyGroupDoesNotExistException(id);
        }
        return Response.ok(maybeStudyGroup.get()).build();
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Response getStudyGroups(
            @QueryParam("filter") List<String> filters,
            @QueryParam("sort") List<String> sorts,
            @QueryParam("page") @Positive(message = "page must be positive") @DefaultValue("1") int page,
            @QueryParam("size") @Positive(message = "size must be positive") @DefaultValue("25") int size
    ) throws WrongFilterException {
        List<StudyGroupEntity> studyGroups = studyGroupService.getAll(filters, sorts, page, size);
        return Response.ok().entity(studyGroups).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}/")
    public Response deleteStudyGroup(
            @PathParam("id") @Positive(message = "id must be positive") int id)
            throws StudyGroupDoesNotExistException {
        studyGroupService.deleteById(id);
        return Response.ok().entity("ok").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/")
    public Response updateStudyGroup(
            @PathParam("id") @Positive(message = "id must be positive") int id,
            @NotNull(message = "Study group must not be null") @Valid StudyGroupBase studyGroup)
            throws StudyGroupDoesNotExistException {
        StudyGroupEntity updatedStudyGroup = studyGroupService.updateById(id, studyGroup);
        return Response.ok().entity(updatedStudyGroup).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createStudyGroup(@NotNull(message = "Study group must not be null") @Valid StudyGroupBase studyGroup) {
        Optional<StudyGroupEntity> maybeCreatedStudyGroup = studyGroupService.create(studyGroup);
        if (maybeCreatedStudyGroup.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().entity(maybeCreatedStudyGroup.get()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all-students-count")
    public Response getAllStudentsCount() {
        long count = studyGroupService.getAllStudentCount();
        return Response.ok().entity(new GetAllStudentsCountResponse(count)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/start-with")
    public Response getAllWithNameStartWith(@NotNull(message = "name must not be null") @QueryParam("name") String name) {
        List<StudyGroupEntity> studyGroups = studyGroupService.getAllWithNameStartWith(name);
        return Response.ok().entity(studyGroups).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/student-count/{studentCount}")
    public Response deleteAllByStudentCount(@NotNull(message = "studentCount must not be null") @PathParam("studentCount") Long studentCount) {
        int countDeleted = studyGroupService.deleteAllByStudentCount((long) studentCount);
        return Response.ok().entity(new DeleteAllByStudentCountResponse(countDeleted)).build();
    }
}
