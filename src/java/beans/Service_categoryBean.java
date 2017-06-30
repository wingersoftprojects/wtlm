/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import entities.Service_category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import utilities.UtilityBean;

/**
 *
 * @author philp
 */
@ManagedBean
@RequestScoped
public class Service_categoryBean {

    private Service_category service_category = new Service_category();
    PreparedStatement ps = null;
    Connection conn = null;
    int i = 0;
    ResultSet rs = null;
    private List<Service_category> Service_categoryList;
    private Service_category Service_categoryObject;

    public Service_category getService_category() {
        return service_category;
    }

    public void setService_category(Service_category service_category) {
        this.service_category = service_category;
    }

    public Service_categoryBean() {
        this.Service_categoryObject = new Service_category();
    }

    public String redirectEdit(Service_category aService_category) {
        this.Service_categoryObject = aService_category;
        return "service_category?faces-redirect=true";
    }

    public String redirectNew() {
        this.Service_categoryObject = new Service_category();
        return "service_category?faces-redirect=true";
    }

    public void insertService_category(Service_category service_category) {
        String sql = "";
        sql = "INSERT INTO service_category(service_category_name) VALUES(?)";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            try {
                ps.setString(1, service_category.getService_category_name());
                i = ps.executeUpdate();
                this.clearService_category(service_category);
                FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Saved succesfully"));
            } catch (NullPointerException npe) {
                FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            }
        } catch (SQLException se) {
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            se.printStackTrace();
        }
    }

    public void updateService_category(Service_category service_category) {
        System.out.println("||||||");
        String sql = "";
        sql = "UPDATE service_category SET service_category_name=? WHERE service_category_id=?";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            try {
                ps.setString(1, service_category.getService_category_name());
            } catch (NullPointerException npe) {
                ps.setString(1, "");
            }
            try {
                ps.setInt(2, service_category.getService_category_id());
            } catch (NullPointerException npe) {
                ps.setInt(2, 0);
            }
            i = ps.executeUpdate();
            this.clearService_category(service_category);
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Updated succesfully"));
        } catch (SQLException se) {
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            se.printStackTrace();
        }
    }

    public List<Service_category> getService_categorys() throws Exception {
        List<Service_category> service_categorys = new ArrayList<>();
        String sql = "SELECT * FROM service_category";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Service_category sc = new Service_category();
                this.setService_categoryFromResultset(sc, rs);
                service_categorys.add(sc);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return service_categorys;
    }

    public void setService_categoryFromResultset(Service_category aService_category, ResultSet rs) {
        try {
            aService_category.setService_category_id(rs.getInt("service_category_id"));
            aService_category.setService_category_name(rs.getString("service_category_name"));

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void clearService_category(Service_category aService_category) {
        if (null != aService_category) {
            aService_category.setService_category_id(0);
            aService_category.setService_category_name("");

        }
    }

    /**
     * @return the Service_categoryList
     */
    public List<Service_category> getService_categoryList() {
        return Service_categoryList;
    }

    /**
     * @param Service_categoryList the Service_categoryList to set
     */
    public void setService_categoryList(List<Service_category> Service_categoryList) {
        this.Service_categoryList = Service_categoryList;
    }

    /**
     * @return the Service_categoryObject
     */
    public Service_category getService_categoryObject() {
        return Service_categoryObject;
    }

    /**
     * @param Service_categoryObject the Service_categoryObject to set
     */
    public void setService_categoryObject(Service_category Service_categoryObject) {
        this.Service_categoryObject = Service_categoryObject;
    }

}
