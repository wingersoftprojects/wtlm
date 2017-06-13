/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.math.BigInteger;
import java.sql.Timestamp;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author philp
 */
@ManagedBean
@SessionScoped
public class License_detail {
    private static final long serialVersionUID = 1L;

    private int License_detail_id;
    private int Wtl_app_id;
    private BigInteger Transactor_id;
    private String License_client_id;
    private String License_client_name;
    private String License_package;
    private String License_expiry_code;
    private String License_code;
    private Timestamp Start_date;
    private Timestamp Expire_date;
    private Timestamp Last_renew_date;
    private float Amount_payable;
    private int Years_payable;
    private String Credentials_server;
    private String Credentials_network;
    private String Narration;
    private int Is_active;
    private int Is_deleted;
    private Timestamp Add_date;
    private int Add_by;
    private Timestamp Last_edit_date;
    private int Last_edit_by;

    public int getLicense_detail_id() {
        return License_detail_id;
    }

    public void setLicense_detail_id(int License_detail_id) {
        this.License_detail_id = License_detail_id;
    }

    public int getWtl_app_id() {
        return Wtl_app_id;
    }

    public void setWtl_app_id(int Wtl_app_id) {
        this.Wtl_app_id = Wtl_app_id;
    }

    public BigInteger getTransactor_id() {
        return Transactor_id;
    }

    public void setTransactor_id(BigInteger Transactor_id) {
        this.Transactor_id = Transactor_id;
    }

    public String getLicense_client_id() {
        return License_client_id;
    }

    public void setLicense_client_id(String License_client_id) {
        this.License_client_id = License_client_id;
    }

    public String getLicense_client_name() {
        return License_client_name;
    }

    public void setLicense_client_name(String License_client_name) {
        this.License_client_name = License_client_name;
    }

    public String getLicense_package() {
        return License_package;
    }

    public void setLicense_package(String License_package) {
        this.License_package = License_package;
    }

    public String getLicense_expiry_code() {
        return License_expiry_code;
    }

    public void setLicense_expiry_code(String License_expiry_code) {
        this.License_expiry_code = License_expiry_code;
    }

    public String getLicense_code() {
        return License_code;
    }

    public void setLicense_code(String License_code) {
        this.License_code = License_code;
    }

    public Timestamp getStart_date() {
        return Start_date;
    }

    public void setStart_date(Timestamp Start_date) {
        this.Start_date = Start_date;
    }

    public Timestamp getExpire_date() {
        return Expire_date;
    }

    public void setExpire_date(Timestamp Expire_date) {
        this.Expire_date = Expire_date;
    }

    public Timestamp getLast_renew_date() {
        return Last_renew_date;
    }

    public void setLast_renew_date(Timestamp Last_renew_date) {
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

    public String getCredentials_server() {
        return Credentials_server;
    }

    public void setCredentials_server(String Credentials_server) {
        this.Credentials_server = Credentials_server;
    }

    public String getCredentials_network() {
        return Credentials_network;
    }

    public void setCredentials_network(String Credentials_network) {
        this.Credentials_network = Credentials_network;
    }

    public String getNarration() {
        return Narration;
    }

    public void setNarration(String Narration) {
        this.Narration = Narration;
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

    public Timestamp getAdd_date() {
        return Add_date;
    }

    public void setAdd_date(Timestamp Add_date) {
        this.Add_date = Add_date;
    }

    public int getAdd_by() {
        return Add_by;
    }

    public void setAdd_by(int Add_by) {
        this.Add_by = Add_by;
    }

    public Timestamp getLast_edit_date() {
        return Last_edit_date;
    }

    public void setLast_edit_date(Timestamp Last_edit_date) {
        this.Last_edit_date = Last_edit_date;
    }

    public int getLast_edit_by() {
        return Last_edit_by;
    }

    public void setLast_edit_by(int Last_edit_by) {
        this.Last_edit_by = Last_edit_by;
    }
    
    
    

}
