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
public class Host_platform {
    private static final long serialVersionUID = 1L;
    
    private int Host_platform_id;
    private String Host_platform_name;

    public int getHost_platform_id() {
        return Host_platform_id;
    }

    public void setHost_platform_id(int Host_platform_id) {
        this.Host_platform_id = Host_platform_id;
    }

    public String getHost_platform_name() {
        return Host_platform_name;
    }

    public void setHost_platform_name(String Host_platform_name) {
        this.Host_platform_name = Host_platform_name;
    }
    
    
    
}
