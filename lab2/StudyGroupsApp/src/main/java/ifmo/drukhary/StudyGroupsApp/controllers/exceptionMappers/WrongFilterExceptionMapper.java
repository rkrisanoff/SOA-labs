package ifmo.drukhary.StudyGroupsApp.controllers.exceptionMappers;

import ifmo.drukhary.StudyGroupsApp.DTO.ErrorData;
import ifmo.drukhary.StudyGroupsApp.exceptions.WrongFilterException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import static ifmo.drukhary.StudyGroupsApp.utils.Constants.STUDY_GROUP_VALIDATION_EXPRESSION;

@Provider
public class WrongFilterExceptionMapper implements ExceptionMapper<WrongFilterException> {
    @Override
    public Response toResponse(WrongFilterException e) {

        return Response.status(Response.Status.BAD_REQUEST).entity(
                        new ErrorData("`" + e.getValue() + "`" + " must be match pattern " + "/" + STUDY_GROUP_VALIDATION_EXPRESSION + "/"))
                .build();
    }
}
