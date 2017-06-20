/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author philp
 */
@ManagedBean
@SessionScoped

public class Web_service {

    private static final long serialVersionUID = 1L;
    
    private int Web_service_id;
    private int Host_platform_id;
    private long Transactor_id;
    private long Admin_transactor_id;
    private String Domain_name;
    private int Service_category_id;
    private int Package_detail_id;
    private Date Start_date;
    private Date Expire_date;
    private Date Last_renew_date;
    private float Amount_payable;
    private int Years_payable;
    private String Narration;
    private String Cpanel_login;
    private String Account_manager;
    private String Wp_login;
    private int Is_active;
    private int Is_deleted;
    private Date Add_date;
    private int Add_by;
    private Date Last_edit_date;
    private int Last_edit_by;

    public int getWeb_service_id() {
        return Web_service_id;
    }

    public void setWeb_service_id(int Web_service_id) {
        this.Web_service_id = Web_service_id;
    }

    public int getHost_platform_id() {
        return Host_platform_id;
    }

    public void setHost_platform_id(int Host_platform_id) {
        this.Host_platform_id = Host_platform_id;
    }

    public long getTransactor_id() {
        return Transactor_id;
    }

    public void setTransactor_id(long Transactor_id) {
        this.Transactor_id = Transactor_id;
    }

    public long getAdmin_transactor_id() {
        return Admin_transactor_id;
    }

    public void setAdmin_transactor_id(long Admin_transactor_id) {
        this.Admin_transactor_id = Admin_transactor_id;
    }

    public String getDomain_name() {
        return Domain_name;
    }

    public void setDomain_name(String Domain_name) {
        this.Domain_name = Domain_name;
    }

    public int getService_category_id() {
        return Service_category_id;
    }

    public void setService_category_id(int Service_category_id) {
        this.Service_category_id = Service_category_id;
    }

    public int getPackage_detail_id() {
        return Package_detail_id;
    }

    public void setPackage_detail_id(int Package_detail_id) {
        this.Package_detail_id = Package_detail_id;
    }

    public Date getStart_date() {
        return Start_date;
    }

    public void setStart_date(Date Start_date) {
        this.Start_date = Start_date;
    }

    public Date getExpire_date() {
        return Expire_date;
    }

    public void setExpire_date(Date Expire_date) {
        this.Expire_date = Expire_date;
    }

    
    public Date getLast_renew_date() {
        return Last_renew_date;
    }

    public void setLast_renew_date(Date Last_renew_date) {
        this.Last_renew_date = Last_renew_date;
    }

    public float getAmount_payable() {
        return Amount_payable;
    }

    public void setAmount_payable(float Amount_payable) {
        this.Amount_payable = Amount_payable;
    }

    public int getYears_payable() {
        return Years_payable;
    }

    public void setYears_payable(int Years_payable) {
        this.Years_payable = Years_payable;
    }

    public String getNarration() {
        return Narration;
    }

    public void setNarration(String Narration) {
        this.Narration = Narration;
    }

    public String getCpanel_login() {
        return Cpanel_login;
    }

    public void setCpanel_login(String Cpanel_login) {
        this.Cpanel_login = Cpanel_login;
    }

    public String getAccount_manager() {
        return Account_manager;
    }

    public void setAccount_manager(String Account_manager) {
        this.Account_manager = Account_manager;
    }

    public String getWp_login() {
        return Wp_login;
    }

    public void setWp_login(String Wp_login) {
        this.Wp_login = Wp_login;
    }

    public int getIs_active() {
        return Is_active;
    }

    public void setIs_active(int Is_active) {
        this.Is_active = Is_active;
    }

    public int getIs_deleted() {
        return Is_deleted;
    }

    public void setIs_deleted(int Is_deleted) {
        this.Is_deleted = Is_deleted;
    }

    public Date getAdd_date() {
        return Add_date;
    }

    public void setAdd_date(Date Add_date) {
        this.Add_date = Add_date;
    }

    public int getAdd_by() {
        return Add_by;
    }

    public void setAdd_by(int Add_by) {
        this.Add_by = Add_by;
    }

    public Date getLast_edit_date() {
        return Last_edit_date;
    }

    public void setLast_edit_date(Date Last_edit_date) {
        this.Last_edit_date = Last_edit_date;
    }

    public int getLast_edit_by() {
        return Last_edit_by;
    }

    public void setLast_edit_by(int Last_edit_by) {
        this.Last_edit_by = Last_edit_by;
    }

}
