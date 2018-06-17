/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.torrent.swing.client;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author kerch
 */
public class DataServiceImpl implements DataService {
    private final String URL_LINK = "http://localhost:8080/torrent-service/webresource/client/api";
    private String login;
    
    @Override
    public boolean login(String login, String password) {
        this.login=login;
        Client client = ClientBuilder.newClient();       
        WebTarget webTarget = client.target(URL_LINK+"/login/"+login+"/"+password);
        boolean result=webTarget.request().get(Boolean.class);
        return result;
    }

    @Override
    public CategoryData getCategory() {
        Client client = ClientBuilder.newClient();       
        WebTarget webTarget = client.target(URL_LINK+"/category/");
        //List<String> result = webTarget.request().get(new GenericType<List<String>>() {
        //});
        return webTarget.request().get(CategoryData.class);
    }

    @Override
    public String search(SearchRequestParameters parameters) {
        Client client = ClientBuilder.newClient();       
        WebTarget webTarget = client.target(URL_LINK+"/search/"+login);
        String result=webTarget.request().post(Entity.json(parameters), String.class);
        return result;
    }
    
}
