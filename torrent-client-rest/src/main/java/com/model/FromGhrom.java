/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author kerch
 */
public class FromGhrom{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
                
                File file = new File("C:\\torent-client-home-rest\\src\\main\\resources\\pirat.html");
		String testHtml = FileUtils.readFileToString(file); // from commons io
                
		String body = StringUtils.substringBetween(testHtml, "<body>", "</body>");
                

                String[] trs = StringUtils.substringsBetween(body, "<tr>", "</tr>");
		TorrentPageParser torrent = new TorrentPageParserImpl();
                List<TorrentItem> items = torrent.parsePage(trs);
                System.out.println(items);


    

    }
    
}
