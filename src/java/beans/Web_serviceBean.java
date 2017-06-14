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
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import static org.apache.tomcat.util.http.FastHttpDateFormat.getCurrentDate;

/**
 *
 * @author philp
 */
@ManagedBean
@RequestScoped
public class Web_serviceBean {

    PreparedStatement ps = null;
    Connection conn = null;
    int i = 0;

    /**
     * Creates a new instance of Web_serviceBean
     */
    public Web_serviceBean() {
    }

    public void save_web_service(Web_service ws) {
        try {
            conn = DBConnection.getMySQLConnection();
            String sql = "INSERT INTO web_service(host_platform_id,transactor_id,admin_transactor_id,domain_name,service_category,package_detail_id,start_date,expiry_date,last_renew_date,amount_payable,years_payable,is_active,narration,account_manager,wp_login,cpanel_login,is_deleted,add_date,add_by,last_edit_date,last_edit_by) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,'2017-06-13 07:33','2017-06-12',1,1)";
            ps = conn.prepareStatement(sql);

            ps.setInt(1, ws.getHost_platform_id());
            ps.setLong(2, ws.getTransactor_id());
            ps.setLong(3, ws.getAdmin_transactor_id());
            ps.setString(4, ws.getDomain_name());
            ps.setInt(5, ws.getService_category_id());
            ps.setInt(6, ws.getPackage_detail_id());
            ps.setDate(7, new java.sql.Date(ws.getStart_date().getTime()));
            ps.setDate(8, new java.sql.Date(ws.getExpiry_date().getTime()));
            ps.setDate(9, new java.sql.Date(ws.getLast_renew_date().getTime()));
            ps.setFloat(10, ws.getAmount_payable());
            ps.setInt(11, ws.getYears_payable());
            ps.setString(12, ws.getNarration());
            ps.setString(13, ws.getAccount_manager());
            ps.setString(14, ws.getWp_login());
            ps.setString(15, ws.getCpanel_login());
            ps.setInt(16, ws.getIs_active());

            i = ps.executeUpdate();
            System.out.println("Added");

        } catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            try {
            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
}
