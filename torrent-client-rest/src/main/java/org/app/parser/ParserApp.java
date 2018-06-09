/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kerch
 */
public class ParserApp {

    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream("C:\\torrent-client-rest\\torrent.txt"));
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(ToorentPageParserImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
        
        
        
        ParserApp parserApp = new ParserApp();
        final String str = parserApp.getContent();
        ToorentPageParser parser = new ToorentPageParserImpl();
        parser.parsePage(str);
       // System.out.println(str);
        
    }

//    private static final Pattern TAG_REGEX_TYPE = Pattern.compile("(?=f\\=\\d{4}\">).*(?=<//a>)");
//    private static final Pattern TAG_REGEX_TOPIC = Pattern.compile("<tag>(.+?)</tag>");
//    private static final Pattern TAG_REGEX_AUTHOR = Pattern.compile("<tag>(.+?)</tag>");
//    private static final Pattern TAG_REGEX_SIZE = Pattern.compile("<tag>(.+?)</tag>");
//    
//    private static List<String> getTagValues(final String str) {
//        final List<String> tagValues = new ArrayList<>();
//        final Matcher matcher = TAG_REGEX_TYPE.matcher(str);
//        while (matcher.find()) {
//            tagValues.add(matcher.group(1));
//        }
//       return tagValues;
//    }

    public String getContent() {
        try (InputStream in = getClass().getResourceAsStream("/example.html");){
           byte[] data = new byte[in.available()];
           in.read(data);
        return new String(data);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    
    public TorrentItem getTorrentItem(List<String> list){
        return null;
    }

}
