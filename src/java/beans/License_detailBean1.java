/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import entities.Package_detail;
import entities.License_detail;
import entities.License_detail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import utilities.UtilityBean;

/**
 *
 * @author philp
 */
@ManagedBean
@SessionScoped
public class License_detailBean1 {

    private License_detail license_detail = new License_detail();
    private Package_detail package_detail = new Package_detail();
    PreparedStatement ps = null;
    Connection conn = null;
    int i = 0;
    ResultSet rs = null;
    private List<License_detail> License_detailList;
    private License_detail License_detailObject;
    private int task_age;

    public License_detail getLicense_detail() {
        return license_detail;
    }

    public void setLicense_detail(License_detail license_detail) {
        this.license_detail = license_detail;
    }

    public License_detailBean1() {
        this.License_detailObject = new License_detail();
    }

    public String redirectEdit(License_detail aLicense_detail) {
        this.License_detailObject = aLicense_detail;
        return "license_detail_detail?faces-redirect=true";
    }

    public void redirectView(License_detail aLicense_detail) {
        this.License_detailObject = aLicense_detail;
//        return "PF('Dialog_View_Web_Service_Detail').show()";
       RequestContext.getCurrentInstance().execute("PF('Dialog_View_License_Detail').show()");

    }

    public String redirectNew() {
        this.License_detailObject = new License_detail();
        return "license_detail_detail?faces-redirect=true";
    }

    public void updateLicense_detail(License_detail license_detail) {
        String sql = "";
        sql = "UPDATE license_detail SET wtl_app_id=?,transactor_id=?,license_client_id=?,license_client_name=?,"
                + "license_package=?,license_expire_code=?,license_code=?,start_date=?,expire_date=?,"
                + "last_renew_date=?,amount_payable=?,years_payable=?,credentials_server=?,"
                + "crendentials_network=?,narration=?,is_active=?,"
                + "is_deleted=?,last_edit_date=?,last_edit_by=?"
                + "where license_detail_id=?";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            try {
                ps.setInt(1, license_detail.getWtl_app_id());
            } catch (NullPointerException npe) {
                ps.setInt(1, 0);
            }
            try {
                ps.setLong(2, license_detail.getTransactor_id());
            } catch (NullPointerException npe) {
                ps.setLong(2, 0);
            }
            try {
                ps.setString(3, license_detail.getLicense_client_id());
            } catch (NullPointerException npe) {
                ps.setString(3, "");
            }
            try {
                ps.setString(4, license_detail.getLicense_client_name());
            } catch (NullPointerException npe) {
                ps.setString(4, "");
            }
            try {
                ps.setString(5, license_detail.getLicense_package());
            } catch (NullPointerException npe) {
                ps.setString(5, "");
            }
            try {
                ps.setString(6, license_detail.getLicense_expire_code());
            } catch (NullPointerException npe) {
                ps.setString(6, "");
            }
            try {
                ps.setString(7, license_detail.getLicense_code());
            } catch (NullPointerException npe) {
                ps.setString(7, "");
            }
            try {
                ps.setDate(8, new java.sql.Date(license_detail.getStart_date().getTime()));
            } catch (NullPointerException npe) {
                ps.setDate(8, null);
            }
            try {
                ps.setDate(9, new java.sql.Date(license_detail.getExpire_date().getTime()));
            } catch (NullPointerException npe) {
                ps.setDate(9, null);
            }
            try {
                ps.setDate(10, new java.sql.Date(license_detail.getLast_renew_date().getTime()));
            } catch (NullPointerException npe) {
                ps.setDate(10, null);
            }
            try {
                ps.setFloat(11, license_detail.getAmount_payable());
            } catch (NullPointerException npe) {
                ps.setFloat(11, 0);
            }
            try {
                ps.setInt(12, license_detail.getYears_payable());
            } catch (NullPointerException npe) {
                ps.setInt(12, 0);
            }

            try {
                ps.setString(13, license_detail.getCredentials_server());
            } catch (NullPointerException npe) {
                ps.setString(13, "");
            }
            try {
                ps.setString(14, license_detail.getCredentials_network());
            } catch (NullPointerException npe) {
                ps.setString(14, "");
            }
            try {
                ps.setString(15, license_detail.getNarration());
            } catch (NullPointerException npe) {
                ps.setString(15, "");
            }
            try {
                ps.setInt(16, license_detail.getIs_active());
            } catch (NullPointerException npe) {
                ps.setInt(16, 0);
            }
            try {
                ps.setInt(17, license_detail.getIs_deleted());
            } catch (NullPointerException npe) {
                ps.setInt(17, 0);
            }
            try {
                ps.setTimestamp(18, new java.sql.Timestamp(new UtilityBean().getCURRENT_SERVER_DATE().getTime()));
            } catch (NullPointerException npe) {
                ps.setTimestamp(18, null);
            }
            try {
                ps.setInt(19, 0);
            } catch (NullPointerException npe) {
                ps.setInt(19, 0);
            }
            try {
                ps.setString(19, license_detail.getLicense_client_id());
            } catch (NullPointerException npe) {
                ps.setInt(19, 0);
            }
            System.out.println(sql);
//            i = ps.executeUpdate();
            this.clearLicense_detail(license_detail);
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Updated succesfully"));
        } catch (SQLException se) {
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            se.printStackTrace();
        }
    }

    public List<License_detail> getLicense_details() throws Exception {
        List<License_detail> license_details = new ArrayList<>();
        String sql = "SELECT * FROM license_detail";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                License_detail ld = new License_detail();
                this.setLicense_detailFromResultset(ld, rs);
                license_details.add(ld);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return license_details;
    }

    public void setLicense_detailFromResultset(License_detail aLicense_detail, ResultSet rs) {
        try {
            aLicense_detail.setLicense_detail_id(rs.getInt("license_detail_id"));
            aLicense_detail.setWtl_app_id(rs.getInt("wtl_app_id"));
            aLicense_detail.setTransactor_id(rs.getLong("transactor_id"));
            aLicense_detail.setLicense_client_id(rs.getString("license_detail_id"));
            aLicense_detail.setLicense_client_name(rs.getString("license_client_name"));
            aLicense_detail.setLicense_package(rs.getString("license_package"));
            aLicense_detail.setLicense_expire_code(rs.getString("license_expire_code"));
            aLicense_detail.setLicense_code(rs.getString("license_code"));
            aLicense_detail.setStart_date(rs.getDate("start_date"));
            aLicense_detail.setExpire_date(rs.getDate("expire_date"));
            aLicense_detail.setLast_renew_date(rs.getDate("last_renew_date"));
            aLicense_detail.setAmount_payable(rs.getFloat("amount_payable"));
            aLicense_detail.setYears_payable(rs.getInt("years_payable"));
            aLicense_detail.setCredentials_server(rs.getString("credentials_server"));
            aLicense_detail.setCredentials_network(rs.getString("credentials_network"));
            aLicense_detail.setNarration(rs.getString("narration"));
            aLicense_detail.setIs_active(rs.getInt("is_active"));
            aLicense_detail.setIs_deleted(rs.getInt("is_deleted"));
            aLicense_detail.setLast_edit_date(rs.getDate("last_edit_date"));
            aLicense_detail.setLast_edit_by(rs.getInt("last_edit_by"));
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void clearLicense_detail(License_detail aLicense_detail) {
        if (null != aLicense_detail) {
            aLicense_detail.setLicense_detail_id(0);
            aLicense_detail.setWtl_app_id(0);
            aLicense_detail.setTransactor_id(0);
            aLicense_detail.setLicense_client_id("");
            aLicense_detail.setLicense_client_name("");
            aLicense_detail.setLicense_package("");
            aLicense_detail.setLicense_expire_code("");
            aLicense_detail.setLicense_code("");
            aLicense_detail.setStart_date(null);
            aLicense_detail.setExpire_date(null);
            aLicense_detail.setLast_renew_date(null);
            aLicense_detail.setAmount_payable(0);
            aLicense_detail.setYears_payable(0);
            aLicense_detail.setCredentials_server("");
            aLicense_detail.setCredentials_network("");
            aLicense_detail.setNarration("");
            aLicense_detail.setIs_active(0);
            aLicense_detail.setIs_deleted(0);
            aLicense_detail.setLast_edit_date(null);
            aLicense_detail.setLast_edit_by(0);
        }
    }

    public void searchLicense_detail(License_detail aLicense_detail) {
        ResultSet res = null;
        this.License_detailList = new ArrayList<>();
        String sql = "SELECT * FROM license_detail WHERE is_deleted=0 AND is_active=1";
        String wheresql = "";
        String orderby = "";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            if (aLicense_detail.getWtl_app_id()> 0) {
                wheresql = wheresql + " AND wtl_app_id=" + aLicense_detail.getWtl_app_id();
            }
            if (aLicense_detail.getStart_date() != null && aLicense_detail.getStart_date2() != null) {
                wheresql = wheresql + " AND start_date BETWEEN '" + new java.sql.Date(aLicense_detail.getStart_date().getTime()) + "' AND '" + new java.sql.Date(aLicense_detail.getStart_date2().getTime()) + "'";
            }
            orderby = " ORDER BY start_date DESC";
            sql = sql + wheresql + orderby;
            System.out.println(sql);
            res = ps.executeQuery(sql);
            License_detail td;
            while (res.next()) {
                td = new License_detail();
                this.setLicense_detailFromResultset(td, res);
                this.License_detailList.add(td);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

        public int getTask_age() {
        return task_age;
    }

    public void setTask_age(int task_age) {
        this.task_age = task_age;
    }

    /**
     * @return the License_detailList
     */
    public List<License_detail> getLicense_detailList() {
        return License_detailList;
    }

    /**
     * @param License_detailList the License_detailList to set
     */
    public void setLicense_detailList(List<License_detail> License_detailList) {
        this.License_detailList = License_detailList;
    }

    /**
     * @return the License_detailObject
     */
    public License_detail getLicense_detailObject() {
        return License_detailObject;
    }

    /**
     * @param License_detailObject the License_detailObject to set
     */
    public void setLicense_detailObject(License_detail License_detailObject) {
        this.License_detailObject = License_detailObject;
    }

    /**
     * @return the package_detail
     */
    public Package_detail getPackage_detail() {
        return package_detail;
    }

    /**
     * @param package_detail the package_detail to set
     */
    public void setPackage_detail(Package_detail package_detail) {
        this.package_detail = package_detail;
    }

}
