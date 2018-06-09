/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kerch
 */
public class ToorentPageParserImpl implements ToorentPageParser {

    @Override
    public List<TorrentItem> parsePage(String content) {
        int start = content.indexOf("<tr class=\"tCenter hl-tr\">");
        int end = content.indexOf("</tr>", start);
        String filmsContent = content.substring(start, end);
        System.out.println(filmsContent);
        if(1<2){
            return null;
        }
        //<tr class="tCenter hl-tr">
        int trStart=filmsContent.indexOf("<tr");
        int trEnd=filmsContent.indexOf("</tr>");
        boolean res = trStart!=-1; 
        while(res){
            String trContent = filmsContent.substring(trStart, trEnd);
            //System.out.println(trContent);
            break;
        }
        return null;
    }
    
}
