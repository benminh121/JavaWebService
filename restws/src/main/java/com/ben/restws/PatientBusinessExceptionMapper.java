package com.ben.restws;

import com.ben.restws.exceptions.PatientBusinessException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PatientBusinessExceptionMapper implements ExceptionMapper<PatientBusinessException> {

    @Override
    public Response toResponse(PatientBusinessException e) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"status\":\"error\"");
        sb.append(",");
        sb.append("\"message\":\"Try again later\"");
        sb.append("}");
        //return Response.status(404).build();
        return Response.serverError().entity(sb.toString()).type(MediaType.APPLICATION_JSON).build();
    }
}
