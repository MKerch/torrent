/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.remote;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author kerch
 */
public class RemoteCallerImpl implements RemoteCaller {
    private Client client = ClientBuilder.newClient();
   
    @Override
    public boolean login(String username, String password) {
        Form form  = new Form();
        form.param("login_username", username);
        form.param("login_password", password);
        form.param("login", "Вход");
        Response response=client.target("http://rutracker.org/form/login.php").request().post(Entity.form(form));
        
        System.out.println(response);
        System.out.println("-------Cookie---------");
        System.out.println(response.getCookies());
        return true;
    }

    


}
