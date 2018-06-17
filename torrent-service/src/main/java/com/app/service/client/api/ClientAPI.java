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
import javax.ws.rs.POST;
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
    
    @POST
    @Path("/search/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String search(SearchRequestParameters searchRequestParameters, @PathParam("username") String username){
        return remoteCaller.getSearchResult(searchRequestParameters, username);
    }

    @GET
    @Path("/category")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoryData getCategory(){
        return remoteCaller.getCategory();
    }
}
