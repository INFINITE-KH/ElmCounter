/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import controller.Counter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author KH
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

        Counter c = new Counter();
    
    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCounter(){
        Gson gson = new Gson();
        return gson.toJson(c.getCounter());
    }
    
    @PUT
    @Path("{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public String setCounter(@PathParam("param") int value){
        c.setCounter(value);
        Gson gson = new Gson();
        return gson.toJson("DONE!!!");
    }

}
