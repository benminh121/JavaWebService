package com.ben.restws;

import com.ben.restws.model.Passenger;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import java.util.List;

@Path("/passengerservice")
@Produces("application/xml")
@Consumes({"application/xml,application/x-www-form-urlencoded"})
public interface PassengerService {
    @Path("/passengers")
    @GET
    List<Passenger> getPassenger(@QueryParam("start") int start, @QueryParam("size") int size);

    @Path("/passengers")
    @POST
//    Passenger addPassenger(Passenger passenger);
    void addPassenger(@FormParam("fname") String fname, @FormParam("lname") String lname, @HeaderParam("agent") String agent, @Context HttpHeaders headers);
}
