package ifmo.drukhary.StudyGroupsApp.controllers.exceptionMappers;

import ifmo.drukhary.StudyGroupsApp.DTO.ErrorDTO;
import ifmo.drukhary.StudyGroupsApp.exceptions.StudyGroupDoesNotExistException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class StudyGroupDoesNotExistExceptionMapper implements ExceptionMapper<StudyGroupDoesNotExistException> {

    public Response toResponse(StudyGroupDoesNotExistException ex) {
        return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorDTO("Study group with "
                + ex.getId() + " does not exist")).build();
    }
}
