package ifmo.drukhary.StudyGroupsApp.controllers.exceptionMappers;

import ifmo.drukhary.StudyGroupsApp.DTO.ErrorDTO;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    public Response toResponse(NotFoundException ex) {
        return Response.status(404).entity(new ErrorDTO("Not Found")).build();
    }
}
