/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import entities.Host_platform;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author philp
 */
@ManagedBean
@SessionScoped
public class Host_platformBean implements Serializable{
    private static final long serialVersionUID = 1L;

    private Host_platform host_platform = new Host_platform();
    PreparedStatement ps = null;
    Connection conn = null;
    int i = 0;
    ResultSet rs = null;
    private List<Host_platform> Host_platformList;
    private Host_platform Host_platformObject;

    public Host_platform getHost_platform() {
        return host_platform;
    }

    public void setHost_platform(Host_platform host_platform) {
        this.host_platform = host_platform;
    }

    public Host_platformBean() {
        this.Host_platformObject = new Host_platform();
    }

    public String redirectEdit(Host_platform aHost_platform) {
        this.Host_platformObject = aHost_platform;
        return "host_platform?faces-redirect=true";
    }

    public String redirectNew() {
        this.Host_platformObject = new Host_platform();
        return "host_platform?faces-redirect=true";
    }

    public void insertHost_platform(Host_platform host_platform) {
        String sql = "";
        sql = "INSERT INTO host_platform(host_platform_name) VALUES(?)";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            try {
                ps.setString(1, host_platform.getHost_platform_name());
                i = ps.executeUpdate();
                this.clearHost_platform(host_platform);
                FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Saved succesfully"));
            } catch (NullPointerException npe) {
                FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            }
        } catch (SQLException se) {
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            se.printStackTrace();
        }
    }

    public void updateHost_platform(Host_platform host_platform) {
        System.out.println("||||||");
        String sql = "";
        sql = "UPDATE host_platform SET host_platform_name=? WHERE host_platform_id=?";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            try {
                ps.setString(1, host_platform.getHost_platform_name());
            } catch (NullPointerException npe) {
                ps.setString(1, "");
            }
            try {
                ps.setInt(2, host_platform.getHost_platform_id());
            } catch (NullPointerException npe) {
                ps.setInt(2, 0);
            }
            i = ps.executeUpdate();
            this.clearHost_platform(host_platform);
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Updated succesfully"));
        } catch (SQLException se) {
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            se.printStackTrace();
        }
    }

    public List<Host_platform> getHost_platforms() throws Exception {
        List<Host_platform> host_platforms = new ArrayList<>();
        String sql = "SELECT * FROM host_platform";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Host_platform sc = new Host_platform();
                this.setHost_platformFromResultset(sc, rs);
                host_platforms.add(sc);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return host_platforms;
    }
    
    public Host_platform getHost_platform(int aHostPlatId){
        Host_platform host_platform = null;
        String sql = "SELECT * FROM host_platform where host_platform_id=" + aHostPlatId;
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery(sql);
            if (rs.next()) {
                host_platform = new Host_platform();
                this.setHost_platformFromResultset(host_platform, rs);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return host_platform;
    }

    public void setHost_platformFromResultset(Host_platform aHost_platform, ResultSet rs) {
        try {
            aHost_platform.setHost_platform_id(rs.getInt("host_platform_id"));
            aHost_platform.setHost_platform_name(rs.getString("host_platform_name"));

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void clearHost_platform(Host_platform aHost_platform) {
        if (null != aHost_platform) {
            aHost_platform.setHost_platform_id(0);
            aHost_platform.setHost_platform_name("");

        }
    }

    /**
     * @return the Host_platformList
     */
    public List<Host_platform> getHost_platformList() {
        return Host_platformList;
    }

    /**
     * @param Host_platformList the Host_platformList to set
     */
    public void setHost_platformList(List<Host_platform> Host_platformList) {
        this.Host_platformList = Host_platformList;
    }

    /**
     * @return the Host_platformObject
     */
    public Host_platform getHost_platformObject() {
        return Host_platformObject;
    }

    /**
     * @param Host_platformObject the Host_platformObject to set
     */
    public void setHost_platformObject(Host_platform Host_platformObject) {
        this.Host_platformObject = Host_platformObject;
    }

}
