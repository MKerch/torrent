/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.remote;

import com.app.service.client.api.CategoryData;
import com.app.service.client.api.SearchRequestParameters;
import java.util.List;

/**
 *
 * @author kerch
 */
public interface RemoteCaller {
    
    public boolean login(String username, String password);
    
    public CategoryData getCategory();
    
    public String getSearchResult(SearchRequestParameters searchRequestParameters, String username);
    
}
