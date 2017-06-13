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
public class Wtl_app {
    private static final long serialVersionUID = 1L;
    
    private int Wtl_app_id;
    private String Wtl_app_name;

    public int getWtl_app_id() {
        return Wtl_app_id;
    }

    public void setWtl_app_id(int Wtl_app_id) {
        this.Wtl_app_id = Wtl_app_id;
    }

    public String getWtl_app_name() {
        return Wtl_app_name;
    }

    public void setWtl_app_name(String Wtl_app_name) {
        this.Wtl_app_name = Wtl_app_name;
    }
    
}
