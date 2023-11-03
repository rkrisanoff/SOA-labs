package ifmo.drukhary.StudyGroupsApp.controllers.exceptionMappers;

import ifmo.drukhary.StudyGroupsApp.DTO.ErrorDTO;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class InternalServerErrorExceptionMapper implements ExceptionMapper<InternalServerErrorException> {

    @Override
    public Response toResponse(InternalServerErrorException arg) {
        return Response.status(Response.Status.BAD_REQUEST).entity(
                        new ErrorDTO("Сервер недоступен"))
                .build();
    }
}
