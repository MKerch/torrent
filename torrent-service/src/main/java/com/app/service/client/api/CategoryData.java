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
public class CategoryData {

    private List<String> categories;

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

}
