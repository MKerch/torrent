/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.client.api;

import com.app.service.remote.RemoteCaller;
import com.app.service.remote.RemoteCallerImpl;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author kerch
 */
@Path("client/api")
public class ClientAPI {
    private RemoteCaller remoteCaller = new RemoteCallerImpl();

    @GET
    @Path("/login/{username}/{password}")
    public boolean login(@PathParam("username") String username, @PathParam("password") String password){
        return remoteCaller.login(username, password);
    }    
    
    @GET
    @Path("/category")
    //@Produces(MediaType)
    public List<String> getCategory(){
        return remoteCaller.getCategory();
    }
}
