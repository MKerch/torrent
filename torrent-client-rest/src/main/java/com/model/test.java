/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author kerch
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String s = "8222945/The_Terminator_(1984)_1080p_BrRip_x264_-_YIFY\" class=\"detLink\" title=\"Details for The Terminator (1984) 1080p BrRip x264 - YIFY\">The Terminator (1984) 1080p BrRip x264 - YIFY</a>";
        int i = s.indexOf("<");
        System.out.println(i);
    }
    
}
