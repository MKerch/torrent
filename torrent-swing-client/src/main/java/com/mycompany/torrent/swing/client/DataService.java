/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.torrent.swing.client;

import java.util.List;


/**
 *
 * @author kerch
 */
public interface DataService {
    
    public boolean login(String login, String password);
    
    public List<String> getCategory();
    
}
