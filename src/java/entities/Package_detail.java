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
public class Package_detail {
    private static final long serialVersionUID = 1L;
    
    private int Package_detail_id;
    private String Package_detail_name;

    public int getPackage_detail_id() {
        return Package_detail_id;
    }

    public void setPackage_detail_id(int Package_detail_id) {
        this.Package_detail_id = Package_detail_id;
    }

    public String getPackage_detail_name() {
        return Package_detail_name;
    }

    public void setPackage_detail_name(String Package_detail_name) {
        this.Package_detail_name = Package_detail_name;
    }
    
    
    
}
