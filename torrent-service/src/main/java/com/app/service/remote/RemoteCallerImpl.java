/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.remote;

import com.app.service.client.api.CategoryData;
import com.app.service.client.api.SearchRequestParameters;
import com.http.communication.internal.api.HttpRequestAPI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.cookie.Cookie;

/**
 *
 * @author kerch
 */
public class RemoteCallerImpl implements RemoteCaller {

    private Map<String, Cookie> cookiePerUser = new HashMap<>();

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
            cookiePerUser.put(username, request.getCookies().get(0));
            loginResult = true;
        }
        return loginResult;
    }

    @Override
    public CategoryData getCategory() {
        CategoryData categoryData = new CategoryData();
        categoryData.setCategories(Arrays.asList("A", "B", "C"));
        return categoryData;
    }

    @Override
    public String getSearchResult(SearchRequestParameters searchRequestParameters, String username) {
        Cookie authCookie = cookiePerUser.get(username);
        HttpRequestAPI request = HttpRequestAPI.getPostRequest("http://rutracker.org/forum/login.php", authCookie);
        request.addParameter("nm", searchRequestParameters.getFilmName());
        request.addParameter("max", "1");
        request.addParameter("to", "1");
        String htmlPage = request.connect();
        return htmlPage;
    }

}
