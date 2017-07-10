/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import entities.Wtl_app;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author philp
 */
@ManagedBean
@SessionScoped
public class Wtl_appBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Wtl_app wtl_app = new Wtl_app();
    PreparedStatement ps = null;
    Connection conn = null;
    int i = 0;
    ResultSet rs = null;
    private List<Wtl_app> Wtl_appList;
    private Wtl_app Wtl_appObject;   
    public Wtl_app getWtl_app() {
        return wtl_app;
    }

    public void setWtl_app(Wtl_app wtl_app) {
        this.wtl_app = wtl_app;
    }

    public Wtl_appBean() {
        this.Wtl_appObject=new Wtl_app();
    }
    
    public String redirectEdit(Wtl_app aWtl_app) {
       this.Wtl_appObject=aWtl_app; 
        return "wtl_app?faces-redirect=true";
    }
    
    public String redirectNew() {
       this.Wtl_appObject=new Wtl_app(); 
        return "wtl_app?faces-redirect=true";
    }

    public void insertWtl_app(Wtl_app wtl_app) {
        String sql = "";
        sql = "INSERT INTO wtl_app(wtl_app_name) VALUES(?)";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            try {
                ps.setString(1, wtl_app.getWtl_app_name());
            } catch (NullPointerException npe) {
                ps.setInt(1, 0);
            }
            i = ps.executeUpdate();
            this.clearWtl_app(wtl_app);
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Saved succesfully"));
        } catch (SQLException se) {
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            se.printStackTrace();
        }
    }

    public void updateWtl_app(Wtl_app wtl_app) {
        String sql = "";
        sql = "UPDATE wtl_app SET wtl_app_name=? WHERE wtl_app_id=?";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            try {
                ps.setString(1, wtl_app.getWtl_app_name());
            } catch (NullPointerException npe) {
                ps.setString(1, "");
            }
            try {
                ps.setInt(2, wtl_app.getWtl_app_id());
            } catch (NullPointerException npe) {
                ps.setInt(2, 0);
            }
            i = ps.executeUpdate();
            this.clearWtl_app(wtl_app);
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Updated succesfully"));
        } catch (SQLException se) {
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            se.printStackTrace();
        }
    }

    public List<Wtl_app> getWtl_apps() throws Exception {
        List<Wtl_app> wtl_apps = new ArrayList<>();
        String sql = "SELECT * FROM wtl_app";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Wtl_app wa = new Wtl_app();
                this.setWtl_appFromResultset(wa, rs);
                wtl_apps.add(wa);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return wtl_apps;
    }

    public void setWtl_appFromResultset(Wtl_app aWtl_app, ResultSet rs) {
        try {
            aWtl_app.setWtl_app_id(rs.getInt("wtl_app_id"));
            aWtl_app.setWtl_app_name(rs.getString("wtl_app_name"));

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void clearWtl_app(Wtl_app aWtl_app) {
        if (null != aWtl_app) {            
            aWtl_app.setWtl_app_id(0);
            aWtl_app.setWtl_app_name("");
            
        }
    }

    /**
     * @return the Wtl_appList
     */
    public List<Wtl_app> getWtl_appList() {
        return Wtl_appList;
    }

    /**
     * @param Wtl_appList the Wtl_appList to set
     */
    public void setWtl_appList(List<Wtl_app> Wtl_appList) {
        this.Wtl_appList = Wtl_appList;
    }

    /**
     * @return the Wtl_appObject
     */
    public Wtl_app getWtl_appObject() {
        return Wtl_appObject;
    }

    /**
     * @param Wtl_appObject the Wtl_appObject to set
     */
    public void setWtl_appObject(Wtl_app Wtl_appObject) {
        this.Wtl_appObject = Wtl_appObject;
    }

}
