/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
/**
 *
 * @author kerch
 */
public class TorrentPageParserImpl implements TorrentPageParser {

    @Override
    public List<TorrentItem> parsePage(String[] trs) {
        List<TorrentItem> items = new ArrayList<>();
        for (String tr : trs) {
            TorrentItem newTorrent = new TorrentItem();
            String type = StringUtils.substringBetween(tr,"<a href=\"/browse/200\" title=\"More from this category\">", "</a>");	
	    newTorrent.setType(type);
            String category = StringUtils.substringBetween(tr,"<a href=\"/browse/207\" title=\"More from this category\">", "</a>");	
            newTorrent.setCategory(category);
            
            String name = StringUtils.substringBetween(tr,"<a href=\"/torrent", "/a>");	
            String clianName = parsName(name);
            newTorrent.setName(clianName);
            
            String size = StringUtils.substringBetween(tr,"<font class=\"detDesc\">", "<a class=\"detDesc\"");	
            String clianSize = parsSize(size);
            newTorrent.setSize(clianSize); 
            items.add(newTorrent);
        }
        return items;
    }
    
    public String parsName(String aTags){

        String name = aTags.substring(aTags.indexOf(">")+1, aTags.indexOf("<"));
        return name;
    }

    private String parsSize(String size) {
        String newSize = size.substring(size.indexOf("Size")+5, size.indexOf("Size")+8);
        return newSize;
    }
    
}
