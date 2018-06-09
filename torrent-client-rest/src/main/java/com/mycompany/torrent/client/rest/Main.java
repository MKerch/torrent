/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.torrent.client.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 *
 * @author kerch
 */
public class Main {

    private static final String PATH = "http://rutracker.org/";
    private static Client client = ClientBuilder.newClient();

    public static void main(String[] args) throws Exception {
       Form form = new Form();
       form.param("redirect", "tracker.php?nm=%D1%82%D0%B5%D1%80%D0%BC%D0%B8%D0%BD%D0%B0%D1%82%D0%BE%D1%80")
           .param("login_username", "MKerch")
           .param("login_password", "Metrovision")
               .param("login","");
       
       /*
       
       redirect: tracker.php?nm=%D1%82%D0%B5%D1%80%D0%BC%D0%B8%D0%BD%D0%B0%D1%82%D0%BE%D1%80
login_username: MKerch
login_password: Metrovision
login: (unable to decode value)
       
       */
        
        
        
        
        WebTarget webTarget = client.target(PATH);

        Response response=webTarget.request("application/x-www-form-urlencoded").
                header("Accept-Encoding", "gzip, deflate, br").
                header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8").
                header("Cache-Control", "max-age=0").
                header("Connection", "keep-alive").
                header("Content-Length", "196").
                header("Content-Type", "application/x-www-form-urlencoded").
                header("Cookie", "bb_ssl=1").
                header("Host", "rutracker.org").
                header("Origin", "https://rutracker.org").
                //header("Referer", "https://rutracker.org/forum/login.php?redirect=tracker.php?nm=%D1%82%D0%B5%D1%80%D0%BC%D0%B8%D0%BD%D0%B0%D1%82%D0%BE%D1%80").
                header("Upgrade-Insecure-Requests", "1").
                header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36").
                post(Entity.form(form));
        MultivaluedMap responseHeader = response.getHeaders();
        System.out.println(responseHeader);
        System.out.println(response.getCookies());
        
        //System.out.println(response);
    }

    /*
    header("Cache-Control", "max-age=0").
header("Connection", "keep-alive").
header("Content-Length", "196").
header("Content-Type", "application/x-www-form-urlencoded").
header("Cookie", "bb_ssl=1").
header("Host", "rutracker.org").
header("Origin", "https://rutracker.org").
header("Referer", "https://rutracker.org/forum/login.php?redirect=tracker.php?nm=%D1%82%D0%B5%D1%80%D0%BC%D0%B8%D0%BD%D0%B0%D1%82%D0%BE%D1%80").
header("Upgrade-Insecure-Requests", 1").
header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36").
     */
}
