/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import entities.Web_service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import utilities.UtilityBean;

/**
 *
 * @author philp
 */
@ManagedBean
@SessionScoped
public class Web_serviceBean {

    PreparedStatement ps = null;
    Connection conn = null;
    int i = 0;
    ResultSet rs = null;

    public Web_serviceBean() {
    }

    public void insertWeb_service(Web_service web_service) {
        String sql = "";
        sql = "INSERT INTO web_service(host_platform_id,transactor_id,admin_transactor_id,domain_name,"
                + "package_detail_id,start_date,expire_date,"
                + "last_renew_date,amount_payable,years_payable,is_active,"
                + "narration,account_manager,wp_login,cpanel_login,"
                + "service_category_id,is_deleted,add_date,add_by,last_edit_date,last_edit_by) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            try {
                ps.setInt(1, web_service.getHost_platform_id());
            } catch (NullPointerException npe) {
                ps.setInt(1, 0);
            }
            try {
                ps.setLong(2, web_service.getTransactor_id());
            } catch (NullPointerException npe) {
                ps.setLong(2, 0);
            }
            try {
                ps.setLong(3, web_service.getAdmin_transactor_id());
            } catch (NullPointerException npe) {
                ps.setInt(3, 0);
            }
            try {
                ps.setString(4, web_service.getDomain_name());
            } catch (NullPointerException npe) {
                ps.setString(4, "");
            }
            try {
                ps.setInt(5, web_service.getService_category_id());
            } catch (NullPointerException npe) {
                ps.setInt(5, 0);
            }
            try {
                ps.setInt(6, web_service.getPackage_detail_id());
            } catch (NullPointerException npe) {
                ps.setInt(6, 0);
            }
            try {
                ps.setDate(7, new java.sql.Date(web_service.getStart_date().getTime()));
            } catch (NullPointerException npe) {
                ps.setDate(7, null);
            }
            try {
                ps.setDate(8, new java.sql.Date(web_service.getExpire_date().getTime()));
            } catch (NullPointerException npe) {
                ps.setDate(8, null);
            }
            try {
                ps.setDate(9, new java.sql.Date(web_service.getLast_renew_date().getTime()));
            } catch (NullPointerException npe) {
                ps.setDate(9, null);
            }
            try {
                ps.setFloat(10, web_service.getAmount_payable());
            } catch (NullPointerException npe) {
                ps.setFloat(10, 0);
            }
            try {
                ps.setInt(11, web_service.getYears_payable());
            } catch (NullPointerException npe) {
                ps.setInt(11, 0);
            }
            try {
                ps.setInt(12, web_service.getIs_active());
            } catch (NullPointerException npe) {
                ps.setInt(12, 0);
            }
            try {
                ps.setString(13, web_service.getNarration());
            } catch (NullPointerException npe) {
                ps.setString(13, "");
            }

            try {
                ps.setString(14, web_service.getAccount_manager());
            } catch (NullPointerException npe) {
                ps.setString(14, "");
            }
            try {
                ps.setString(15, web_service.getWp_login());
            } catch (NullPointerException npe) {
                ps.setString(15, "");
            }
            try {
                ps.setString(16, web_service.getCpanel_login());
            } catch (NullPointerException npe) {
                ps.setString(16, "");
            }
            try {
                ps.setInt(17, web_service.getIs_deleted());
            } catch (NullPointerException npe) {
                ps.setInt(17, 0);
            }
            try {
                ps.setTimestamp(18, new java.sql.Timestamp(new UtilityBean().getCURRENT_SERVER_DATE().getTime()));
            } catch (NullPointerException npe) {
                ps.setDate(18, null);
            }
            try {
                ps.setInt(19, web_service.getAdd_by());
            } catch (NullPointerException npe) {
                ps.setInt(19, 0);
            }
            try {
                ps.setDate(20, null);
            } catch (NullPointerException npe) {
                ps.setDate(20, null);
            }
            try {
                ps.setInt(21, 0);
            } catch (NullPointerException npe) {
                ps.setInt(21, 0);
            }
            i = ps.executeUpdate();
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Saved succesfully"));
        } catch (SQLException se) {
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            se.printStackTrace();
        }
    }
}
//    public void save_web_service(Web_service ws) {
//        try {
//            conn = DBConnection.getMySQLConnection();
//            String sql = "INSERT INTO web_service(host_platform_id,transactor_id,admin_transactor_id,domain_name,"
//                    + "package_detail_id,start_date,expire_date,"
//                    + "last_renew_date,amount_payable,years_payable,is_active,"
//                    + "narration,account_manager,wp_login,cpanel_login,"
//                    + "service_category_id,is_deleted,add_date,add_by) "
//                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1,0,'2017-06-13 07:33',1)";
//            ps = conn.prepareStatement(sql);
//
//            ps.setInt(1, ws.getHost_platform_id());
//            ps.setLong(2, ws.getTransactor_id());
//            ps.setLong(3, ws.getAdmin_transactor_id());
//            ps.setString(4, ws.getDomain_name());
//            //s.setInt(5, ws.getService_category_id());
//            ps.setInt(5, ws.getPackage_detail_id());
//            ps.setDate(6, new java.sql.Date(ws.getStart_date().getTime()));
//            ps.setDate(7, new java.sql.Date(ws.getExpire_date().getTime()));
//            ps.setDate(8, new java.sql.Date(ws.getLast_renew_date().getTime()));
//            ps.setFloat(9, ws.getAmount_payable());
//            ps.setInt(10, ws.getYears_payable());
//            ps.setInt(11, ws.getIs_active());
//            ps.setString(12, ws.getNarration());
//            ps.setString(13, ws.getAccount_manager());
//            ps.setString(14, ws.getWp_login());
//            ps.setString(15, ws.getCpanel_login());
//            i = ps.executeUpdate();
//            System.out.println("Added");
//        } catch (SQLException se) {
//            se.printStackTrace();
//        }
//
//    }
//}
