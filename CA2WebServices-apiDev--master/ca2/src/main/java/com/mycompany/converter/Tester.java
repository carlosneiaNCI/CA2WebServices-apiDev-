package com.mycompany.converter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * @authors: Joseph McDonnell - X17164761  
 *           Marcin Krzeminski – X17158851 
 *           Kevin Shannon - X17160324 
 *           Carlos Neia – X12116394 
 */
@Path("/hello")
public class Tester {
    
    @GET
    @Path("/{param}")
    public Response sayHelloWorld(@PathParam("param") String message) {
        String output = "Hello " + message + "!!!";
        return Response.status(200).entity(output).build();
    } 
}
