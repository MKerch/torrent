/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.remote;

import com.http.communication.internal.api.HttpRequestAPI;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kerch
 */
public class RemoteCallerImpl implements RemoteCaller {

    @Override
    public boolean login(String username, String password) {
        HttpRequestAPI request = HttpRequestAPI.getPostRequest("http://rutracker.org/forum/login.php");
        request.addParameter("login_username", username);
        request.addParameter("login_password", password);
        request.addParameter("login", "Вход");
        request.connect();
        System.out.println(request.getCookies());
        boolean loginResult = false;
        if (request.getCookies() != null && !request.getCookies().isEmpty()) {
            loginResult = true;
        }
        return loginResult;
    }

    @Override
    public List<String> getCategory() {
        return Arrays.asList("A", "B", "C");
    }

}
