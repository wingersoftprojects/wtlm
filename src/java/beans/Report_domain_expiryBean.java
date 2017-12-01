/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import entities.Transactor;
import entities.Web_service;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author philp
 */
@ManagedBean
@SessionScoped
public class Report_domain_expiryBean implements Serializable{

    private ArrayList<Object> Web_serviceList;
    private ResultSet rs;
    private Transactor SelectedTransactor;

    /**
     * Creates a new instance of Report_domain_expiryBean
     */
    public Report_domain_expiryBean() {
    }
    public void searchWeb_service(Web_service aWeb_service) {
        ResultSet res = null;
        this.Web_serviceList = new ArrayList<>();
        String sql = "SELECT * FROM web_service WHERE is_deleted=0";
        String wheresql = "";
        String orderby = "";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            if (aWeb_service.getHost_platform_id() > 0) {
                wheresql = wheresql + " AND host_platform_id=" + aWeb_service.getHost_platform_id();
            }
            if (aWeb_service.getService_category_id() > 0) {
                wheresql = wheresql + " AND service_category_id=" + aWeb_service.getService_category_id();
            }
            if (aWeb_service.getPackage_detail_id() > 0) {
                wheresql = wheresql + " AND package_detail_id=" + aWeb_service.getPackage_detail_id();
            }
            if (aWeb_service.getStart_date() != null && aWeb_service.getStart_date2() != null) {
                wheresql = wheresql + " AND start_date BETWEEN '" + new java.sql.Date(aWeb_service.getStart_date().getTime()) + "' AND '" + new java.sql.Date(aWeb_service.getStart_date2().getTime()) + "'";
            }
            orderby = " ORDER BY add_date DESC";
            sql = sql + wheresql + orderby;
            System.out.println(sql);
            res = ps.executeQuery(sql);
            Web_service ws;
            while (res.next()) {
                ws = new Web_service();
                this.setWeb_serviceFromResultset(ws, res);
                this.Web_serviceList.add(ws);
            }
        } catch (SQLException se) {
            System.out.println(se);
        }
    }
        public void setWeb_serviceFromResultset(Web_service aWeb_service, ResultSet rs) {
        try {
            aWeb_service.setWeb_service_id(rs.getInt("web_service_id"));
            aWeb_service.setHost_platform_id(rs.getInt("host_platform_id"));
            aWeb_service.setTransactor_id(rs.getInt("transactor_id"));
            aWeb_service.setAdmin_transactor_id(rs.getInt("admin_transactor_id"));
            aWeb_service.setDomain_name(rs.getString("domain_name"));
            aWeb_service.setService_category_id(rs.getInt("service_category_id"));
            aWeb_service.setPackage_detail_id(rs.getInt("package_detail_id"));
            aWeb_service.setStart_date(rs.getDate("start_date"));
            aWeb_service.setExpire_date(rs.getDate("expire_date"));
            aWeb_service.setLast_renew_date(rs.getDate("last_renew_date"));
            aWeb_service.setAmount_payable(rs.getFloat("amount_payable"));
            aWeb_service.setYears_payable(rs.getInt("years_payable"));
            aWeb_service.setIs_active(rs.getString("is_active"));
            aWeb_service.setNarration(rs.getString("narration"));
            aWeb_service.setAccount_manager(rs.getString("account_manager"));
            aWeb_service.setWp_login(rs.getString("wp_login"));
            aWeb_service.setCpanel_login(rs.getString("cpanel_login"));
            aWeb_service.setIs_deleted(rs.getInt("is_deleted"));
            aWeb_service.setLast_edit_date(rs.getDate("last_edit_date"));
            aWeb_service.setLast_edit_by(rs.getInt("last_edit_by"));
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void clearWeb_service(Web_service aWeb_service) {
        if (null != aWeb_service) {
            aWeb_service.setWeb_service_id(0);
            aWeb_service.setHost_platform_id(0);
            aWeb_service.setTransactor_id(0);
            aWeb_service.setAdmin_transactor_id(0);
            aWeb_service.setDomain_name("");
            aWeb_service.setService_category_id(0);
            aWeb_service.setPackage_detail_id(0);
            aWeb_service.setStart_date(null);
            aWeb_service.setExpire_date(null);
            aWeb_service.setLast_renew_date(null);
            aWeb_service.setAmount_payable(0);
            aWeb_service.setYears_payable(0);
            aWeb_service.setIs_active("");
            aWeb_service.setNarration("");
            aWeb_service.setAccount_manager("");
            aWeb_service.setWp_login("");
            aWeb_service.setCpanel_login("");
            aWeb_service.setIs_deleted(0);
            aWeb_service.setLast_edit_date(null);
            aWeb_service.setLast_edit_by(0);
            new TransactorBean().clearTransactor(this.SelectedTransactor);
        }
    }
    
    public Web_service getWeb_service(int aWeb_service_id) {
        Web_service web_service = null;
        String sql = "SELECT * FROM web_service where web_service_id=" + aWeb_service_id;
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery(sql);
            if (rs.next()) {
                web_service = new Web_service();
                this.setWeb_serviceFromResultset(web_service, rs);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return web_service;
    }
}
