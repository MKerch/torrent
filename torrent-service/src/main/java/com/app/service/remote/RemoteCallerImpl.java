/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.remote;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kerch
 */
public class RemoteCallerImpl implements RemoteCaller {

    @Override
    public boolean login(String username, String password) {
        return true;
    }

    @Override
    public List<String> getCategory() {
        return Arrays.asList("A", "B", "C");
    }

}
