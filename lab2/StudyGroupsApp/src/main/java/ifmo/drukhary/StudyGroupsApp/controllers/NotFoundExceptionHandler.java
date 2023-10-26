package ifmo.drukhary.StudyGroupsApp.controllers;

import ifmo.drukhary.StudyGroupsApp.DTO.ErrorDTO;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.List;

@Provider
public class NotFoundExceptionHandler implements ExceptionMapper<NotFoundException> {

    @Context
    private HttpHeaders headers;

    public Response toResponse(NotFoundException ex){
        return Response.status(404).entity(new ErrorDTO("Not Found")).type( getAcceptType()).build();
    }

    private String getAcceptType(){
        List<MediaType> accepts = headers.getAcceptableMediaTypes();
        if (accepts!=null && !accepts.isEmpty()) {
            return "";
        }else {
            return "";//return a default one like Application/json
        }
    }
}
