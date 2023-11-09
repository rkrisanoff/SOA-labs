package ifmo.drukhary.StudyGroupsApp.controllers.exceptionMappers;

import ifmo.drukhary.StudyGroupsApp.DTO.ErrorData;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import static jakarta.ws.rs.core.Response.Status.NOT_FOUND;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    public Response toResponse(NotFoundException ex) {
        return Response.status(NOT_FOUND).entity(new ErrorData("Not Found")).build();
    }
}
