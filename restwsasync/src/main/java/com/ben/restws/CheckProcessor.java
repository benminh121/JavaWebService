package com.ben.restws;

import com.ben.restws.model.ChecksList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

@Path("/checkprocessingservice")
public interface CheckProcessor {
    @POST
    @Path("checks")
    public void processChecks(@Suspended AsyncResponse response, ChecksList checksList);
}
