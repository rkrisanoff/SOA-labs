package ifmo.drukhary.StudyGroupsApp.controllers;

import ifmo.drukhary.StudyGroupsApp.exceptions.StudyGroupDoesntExistException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable arg) {
        if (arg.getCause() instanceof StudyGroupDoesntExistException){
            return Response.status(Response.Status.BAD_REQUEST).entity("Study group doesn't exist!")
                    .build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(arg.getMessage())
                .build();
    }
}
