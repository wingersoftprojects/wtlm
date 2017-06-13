/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author philp
 */

@ManagedBean
@SessionScoped
public class Service_category {
    private static final long serialVersionUID = 1L;
    
    private int Service_category_id;
    private String Service_category_name;

    public int getService_category_id() {
        return Service_category_id;
    }

    public void setService_category_id(int Service_category_id) {
        this.Service_category_id = Service_category_id;
    }

    public String getService_category_name() {
        return Service_category_name;
    }

    public void setService_category_name(String Service_category_name) {
        this.Service_category_name = Service_category_name;
    }
    
    
    
}
