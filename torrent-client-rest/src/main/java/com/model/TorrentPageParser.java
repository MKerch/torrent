/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.List;

/**
 *
 * @author kerch
 */
public interface TorrentPageParser {
    
    public List<TorrentItem> parsePage(String[] content);
    
}
