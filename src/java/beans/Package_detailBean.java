/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import entities.Package_detail;
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
public class Package_detailBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Package_detail package_detail = new Package_detail();
    PreparedStatement ps = null;
    Connection conn = null;
    int i = 0;
    ResultSet rs = null;
    private List<Package_detail> Package_detailList;
    private Package_detail Package_detailObject;

    public Package_detail getPackage_detail() {
        return package_detail;
    }

    public void setPackage_detail(Package_detail package_detail) {
        this.package_detail = package_detail;
    }

    public Package_detailBean() {
        this.Package_detailObject = new Package_detail();
    }

    public String redirectEdit(Package_detail aPackage_detail) {
        this.Package_detailObject = aPackage_detail;
        return "package_detail?faces-redirect=true";
    }

    public String redirectNew() {
        this.Package_detailObject = new Package_detail();
        return "package_detail?faces-redirect=true";
    }

    public void insertPackage_detail(Package_detail package_detail) {
        String sql = "";
        sql = "INSERT INTO package_detail(package_name,quota_mbs,bw_mbs,emails,ftp,dbs,other_details)"
                + " VALUES(?,?,?,?,?,?,?)";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            try {
                ps.setString(1, package_detail.getPackage_detail_name());
            } catch (NullPointerException npe) {
                ps.setString(1, "");
            }
            try {
                ps.setFloat(2, package_detail.getQuota_mbs());
            } catch (NullPointerException npe) {
                ps.setFloat(2, 0);
            }
            try {
                ps.setFloat(3, package_detail.getBw_mbs());
            } catch (NullPointerException npe) {
                ps.setInt(3, 0);
            }
            try {
                ps.setInt(4, package_detail.getEmails());
            } catch (NullPointerException npe) {
                ps.setInt(4, 0);
            }
            try {
                ps.setInt(5, package_detail.getFtp());
            } catch (NullPointerException npe) {
                ps.setInt(5, 0);
            }
            try {
                ps.setInt(6, package_detail.getDbs());
            } catch (NullPointerException npe) {
                ps.setInt(6, 0);
            }
            try {
                ps.setString(7, package_detail.getOther_details());
            } catch (NullPointerException npe) {
                ps.setString(7, "");
            }
            i = ps.executeUpdate();
            this.clearPackage_detail(package_detail);
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Saved succesfully"));
        } catch (SQLException se) {
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            se.printStackTrace();
        }
    }

    public void updatePackage_detail(Package_detail package_detail) {
        String sql = "";
        sql = "UPDATE package_detail SET package_name=?,quota_mbs=?,bw_mbs=?,emails=?,"
                + "ftp=?,dbs=?,other_details=?"
                + " WHERE package_detail_id=?";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            try {
                ps.setString(1, package_detail.getPackage_detail_name());
            } catch (NullPointerException npe) {
                ps.setString(1, "");
            }
            try {
                ps.setFloat(2, package_detail.getQuota_mbs());
            } catch (NullPointerException npe) {
                ps.setFloat(2, 0);
            }
            try {
                ps.setFloat(3, package_detail.getBw_mbs());
            } catch (NullPointerException npe) {
                ps.setFloat(3, 0);
            }
            try {
                ps.setInt(4, package_detail.getEmails());
            } catch (NullPointerException npe) {
                ps.setInt(4, 0);
            }
            try {
                ps.setInt(5, package_detail.getFtp());
            } catch (NullPointerException npe) {
                ps.setInt(5, 0);
            }
            try {
                ps.setInt(6, package_detail.getDbs());
            } catch (NullPointerException npe) {
                ps.setInt(6, 0);
            }
            try {
                ps.setString(7, package_detail.getOther_details());
            } catch (NullPointerException npe) {
                ps.setString(7, "");
            }
            try {
                ps.setInt(8, package_detail.getPackage_detail_id());
            } catch (NullPointerException npe) {
                ps.setInt(8, 0);
            }
            i = ps.executeUpdate();
            this.clearPackage_detail(package_detail);
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Updated succesfully"));
        } catch (SQLException se) {
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            se.printStackTrace();
        }
    }

    public List<Package_detail> getPackage_details() throws Exception {
        List<Package_detail> package_details = new ArrayList<>();
        String sql = "SELECT * FROM package_detail";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Package_detail pd = new Package_detail();
                this.setPackage_detailFromResultset(pd, rs);
                package_details.add(pd);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return package_details;
    }

    public void setPackage_detailFromResultset(Package_detail aPackage_detail, ResultSet rs) {
        try {
            aPackage_detail.setPackage_detail_id(rs.getInt("package_detail_id"));
            aPackage_detail.setPackage_detail_name(rs.getString("package_name"));
            aPackage_detail.setQuota_mbs(rs.getFloat("quota_mbs"));
            aPackage_detail.setBw_mbs(rs.getFloat("bw_mbs"));
            aPackage_detail.setEmails(rs.getInt("emails"));
            aPackage_detail.setFtp(rs.getInt("ftp"));
            aPackage_detail.setDbs(rs.getInt("dbs"));
            aPackage_detail.setOther_details(rs.getString("other_details"));

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void clearPackage_detail(Package_detail aPackage_detail) {
        if (null != aPackage_detail) {
            aPackage_detail.setPackage_detail_id(0);
            aPackage_detail.setPackage_detail_name("");
            aPackage_detail.setQuota_mbs(0);
            aPackage_detail.setBw_mbs(0);
            aPackage_detail.setEmails(0);
            aPackage_detail.setFtp(0);
            aPackage_detail.setDbs(0);
            aPackage_detail.setOther_details("");

        }
    }

    /**
     * @return the Package_detailList
     */
    public List<Package_detail> getPackage_detailList() {
        return Package_detailList;
    }

    /**
     * @param Package_detailList the Package_detailList to set
     */
    public void setPackage_detailList(List<Package_detail> Package_detailList) {
        this.Package_detailList = Package_detailList;
    }

    /**
     * @return the Package_detailObject
     */
    public Package_detail getPackage_detailObject() {
        return Package_detailObject;
    }

    /**
     * @param Package_detailObject the Package_detailObject to set
     */
    public void setPackage_detailObject(Package_detail Package_detailObject) {
        this.Package_detailObject = Package_detailObject;
    }

}
