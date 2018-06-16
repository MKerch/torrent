/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.remote;

import java.io.File;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author kerch
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path = "C:\\GIT_PROJECTS\\torrent\\torrent-service\\src\\main\\resources\\Terminator.html";
        File file = new File(path);
    
    {
        try {
            String testHtml = FileUtils.readFileToString(file);
            GetParam get = new GetParamImpl();
            String torrentHref = get.getTorrentHref(testHtml);
            System.out.println(torrentHref);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
 }   
}
