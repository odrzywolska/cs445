package edu.iit.cs445.vin.rest;

/**
 * Created by odrzy_000 on 4/13/2015.
 */
import javax.ws.rs.*;

@Path("/sub")
public class SubscriberService {

    @POST
    @Path("/")
    public String createSub(){
        return null;
    }

    @PUT
    @Path("/{uid}")
    public String updateSub(@PathParam("uid") int id){
        return "Hello World " + id;
    }

    @GET
    @Path("/{uid}")
    public String getSub(@PathParam("uid") int id){
        return "Hello World " + id;
    }
}
