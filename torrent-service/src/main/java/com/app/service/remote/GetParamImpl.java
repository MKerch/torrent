/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.remote;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author kerch
 */
public class GetParamImpl implements GetParam { 
    
        
    
    
    @Override
    public List<String> getCategory() {
        return null;
    }

    @Override
    public String getTorrentHref(String page) {
        String td = StringUtils.substringBetween(page, "<td style=\"width: 15%;\" rowspan=\"4\" class=\"tCenter pad_6\">", "</td>");
        String hrefRaw = StringUtils.substringBetween(td, "<a href=\"dl.php?t=5556958\" class=\"dl-stub\">", "</a>");
        String href = hrefParser(hrefRaw);
        return href;
    }
    public String hrefParser(String rawHref){
        String href = rawHref.substring(rawHref.indexOf("/static"), rawHref.indexOf("\" alt="));
        return href;
    }
}

