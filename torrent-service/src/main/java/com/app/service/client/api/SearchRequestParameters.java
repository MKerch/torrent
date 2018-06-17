/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.client.api;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Denis
 */
@XmlRootElement
public class SearchRequestParameters {
    private String filmName;
    private List<String> categoris;

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public List<String> getCategoris() {
        return categoris;
    }

    public void setCategoris(List<String> categoris) {
        this.categoris = categoris;
    }

}
