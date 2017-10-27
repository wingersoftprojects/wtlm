/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import entities.Package_detail;
import entities.Transactor;
import entities.Web_service;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Web_serviceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Web_service web_service = new Web_service();
    private Package_detail package_detail = new Package_detail();
    PreparedStatement ps = null;
    Connection conn = null;
    int i = 0;
    ResultSet rs = null;
    private List<Web_service> Web_serviceList;
    private Web_service Web_serviceObject;
    private float total_payment_yearly;
    private Transactor SelectedTransactor;

    public Web_service getWeb_service() {
        return web_service;
    }

    public void setWeb_service(Web_service web_service) {
        this.web_service = web_service;
    }

    public Web_serviceBean() {
        this.Web_serviceObject = new Web_service();
    }

    public String redirectEdit(Web_service aWeb_service) {
        this.Web_serviceObject = aWeb_service;
        return "web_service_detail?faces-redirect=true";
    }

    public void view_web_service(int web_service_id) {
        try {
            this.setWeb_serviceObject(getWeb_service(web_service_id));
            Web_serviceList = new ArrayList<>(this.getWeb_serviceObject().getWeb_service_id());
        } catch (Exception e) {
            Logger.getLogger(Web_serviceBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String redirectNew() {
        this.Web_serviceObject = new Web_service();
        return "web_service_detail?faces-redirect=true";
    }

    public void insertWeb_service(Web_service web_service) {
        String sql = "";
        sql = "INSERT INTO web_service(host_platform_id,transactor_id,admin_transactor_id,domain_name,"
                + "service_category_id,package_detail_id,start_date,expire_date,"
                + "last_renew_date,amount_payable,years_payable,is_active,"
                + "narration,account_manager,wp_login,cpanel_login,"
                + "is_deleted,add_date,add_by,last_edit_date,last_edit_by) "
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
                ps.setString(12, web_service.getIs_active());
            } catch (NullPointerException npe) {
                ps.setString(12, "");
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
            this.clearWeb_service(web_service);
            new TransactorBean().clearTransactor(this.SelectedTransactor);
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Saved succesfully"));
        } catch (SQLException se) {
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            se.printStackTrace();
        }
    }

    public void updateWeb_service(Web_service web_service) {
        String sql = "";
        sql = "UPDATE web_service SET host_platform_id=?,transactor_id=?,admin_transactor_id=?,domain_name=?,"
                + "service_category_id=?,package_detail_id=?,start_date=?,expire_date=?,last_renew_date=?,"
                + "amount_payable=?,years_payable=?,is_active=?,narration=?,"
                + "account_manager=?,wp_login=?,cpanel_login=?,"
                + "is_deleted=?,last_edit_date=?,last_edit_by=? "
                + "WHERE web_service_id=?";
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
                ps.setLong(3, 0);
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
                ps.setString(12, web_service.getIs_active());
            } catch (NullPointerException npe) {
                ps.setString(12, "");
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
                ps.setTimestamp(18, null);
            }
            try {
                ps.setInt(19, 0);
            } catch (NullPointerException npe) {
                ps.setInt(19, 0);
            }
            try {
                ps.setInt(20, web_service.getWeb_service_id());
            } catch (NullPointerException npe) {
                ps.setInt(20, 0);
            }
            System.out.println(sql);
            i = ps.executeUpdate();
            this.clearWeb_service(web_service);
            new TransactorBean().clearTransactor(this.SelectedTransactor);
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Updated succesfully"));
        } catch (SQLException se) {
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            se.printStackTrace();
        }
    }

    public void deleteWeb_service(Web_service web_service) {
        String sql = "";
        sql = "UPDATE web_service SET is_deleted=?,last_edit_date=?,last_edit_by=?"
                + " WHERE web_service_id=?";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            try {
                ps.setInt(1, 1);
            } catch (NullPointerException npe) {
                ps.setInt(1, 0);
            }
            try {
                ps.setTimestamp(2, new java.sql.Timestamp(new UtilityBean().getCURRENT_SERVER_DATE().getTime()));
            } catch (NullPointerException npe) {
                ps.setTimestamp(2, null);
            }
            try {
                ps.setInt(3, 0);
            } catch (NullPointerException npe) {
                ps.setInt(3, 0);
            }
            try {
                ps.setInt(4, web_service.getWeb_service_id());
            } catch (NullPointerException npe) {
                ps.setInt(4, 0);
            }
            System.out.println(sql);
            i = ps.executeUpdate();
            this.clearWeb_service(web_service);
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Deleted succesfully"));
        } catch (SQLException se) {
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            se.printStackTrace();
        }
    }

    public List<Web_service> getWeb_services() throws Exception {
        List<Web_service> web_services = new ArrayList<>();
        String sql = "SELECT * FROM web_service";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Web_service ws = new Web_service();
                this.setWeb_serviceFromResultset(ws, rs);
                web_services.add(ws);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return web_services;
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

    public void computeTotal_yearly_payment() {
        ResultSet res = null;
        String sql = "SELECT sum(amount_payable/years_payable)"
                + " AS total_payment_yearly FROM web_service"
                + " WHERE is_deleted=0 AND is_active='Yes';";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            System.out.println(sql);
            res = ps.executeQuery(sql);
            while (res.next()) {
                this.total_payment_yearly = res.getFloat("total_payment_yearly");                
            }
        } catch (SQLException se) {
            System.out.println(se);
        }
    }

    /**
     * @return the Web_serviceList
     */
    public List<Web_service> getWeb_serviceList() {
        return Web_serviceList;
    }

    /**
     * @param Web_serviceList the Web_serviceList to set
     */
    public void setWeb_serviceList(List<Web_service> Web_serviceList) {
        this.Web_serviceList = Web_serviceList;
    }

    /**
     * @return the Web_serviceObject
     */
    public Web_service getWeb_serviceObject() {
        return Web_serviceObject;
    }

    /**
     * @param Web_serviceObject the Web_serviceObject to set
     */
    public void setWeb_serviceObject(Web_service Web_serviceObject) {
        this.Web_serviceObject = Web_serviceObject;
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

    /**
     * @return the total_payment_yearly
     */
    public float getTotal_payment_yearly() {
//        computeTotal_yearly_payment();
        return total_payment_yearly;
    }

    /**
     * @param total_payment_yearly the Total_payment_yearly to set
     */
    public void setTotal_payment_yearly(float total_payment_yearly) {
        this.total_payment_yearly = total_payment_yearly;
    }
    
    /**
     * @return the SelectedTransactor
     */
    public Transactor getSelectedTransactor() {
        return SelectedTransactor;
    }

    /**
     * @param SelectedTransactor the SelectedTransactor to set
     */
    public void setSelectedTransactor(Transactor SelectedTransactor) {
        this.SelectedTransactor = SelectedTransactor;
    }

}
