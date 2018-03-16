/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.UUID;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("elm")
public class ElmResource {

    @Context
    private UriInfo context;

    public ElmResource() {
    }

    @GET
    @Path("counter")
    @Produces(MediaType.APPLICATION_JSON)
    public String getElm() {
        int incriment = 0;
        String data = "{\"counter\": " + "\"" + incriment++ + "\"" + "}";
        return data;
    }

    @PUT
    @Path("counter/{value}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateElm(@PathParam("value") int value) {
        String data = "{\"counter\": " + "\"" + value + "\"" + "}";
        return data;
    }
}