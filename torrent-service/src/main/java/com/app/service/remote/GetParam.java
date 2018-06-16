/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.remote;

import java.util.List;

/**
 *
 * @author kerch
 */
public interface GetParam {
    public List<String> getCategory();
    
    public String getTorrentHref(String page);
    
    
}
