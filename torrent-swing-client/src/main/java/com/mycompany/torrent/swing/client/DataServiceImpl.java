/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.torrent.swing.client;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author kerch
 */
public class DataServiceImpl implements DataService {
    private final String URL_LINK = "http://localhost:8080/torrent-service/webresource/client/api";

    @Override
    public boolean login(String login, String password) {
        Client client = ClientBuilder.newClient();       
        WebTarget webTarget = client.target(URL_LINK+"/login/"+login+"/"+password);
        boolean result=webTarget.request().get(Boolean.class);
        return result;
    }

    @Override
    public List<String> getCategory() {
        Client client = ClientBuilder.newClient();       
        WebTarget webTarget = client.target(URL_LINK+"/category/");
        List<String> result = webTarget.request().get(List.class);
        return result;
    }
    
}
