/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
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

    private String ClientId;
    private String PackageName;
    private String ExpiryDate;
    private String ClientName;
    private Date Start_date2;
    private int License_detail_id;
    private int Wtl_app_id;
    private String Wtl_app_name;
    private long Transactor_id;
    private String License_client_id;
    private String License_client_name;
    private String License_package;
    private String License_expire_code;
    private String License_code;
    private Date Start_date;
    private Date Expire_date;
    private Date Last_renew_date;
    private float Amount_payable;
    private int Years_payable;
    private String Credentials_server;
    private String Credentials_network;
    private String Narration;
    private int Is_active;
    private int Is_deleted;
    private Date Add_date;
    private int Add_by;
    private Date Last_edit_date;
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

    public String getLicense_code() {
        return License_code;
    }

    public void setLicense_code(String License_code) {
        this.License_code = License_code;
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

    public int getAdd_by() {
        return Add_by;
    }

    public void setAdd_by(int Add_by) {
        this.Add_by = Add_by;
    }

    public int getLast_edit_by() {
        return Last_edit_by;
    }

    public void setLast_edit_by(int Last_edit_by) {
        this.Last_edit_by = Last_edit_by;
    }

    /**
     * @return the ClientId
     */
    public String getClientId() {
        return ClientId;
    }

    /**
     * @param ClientId the ClientId to set
     */
    public void setClientId(String ClientId) {
        this.ClientId = ClientId;
    }

    /**
     * @return the PackageName
     */
    public String getPackageName() {
        return PackageName;
    }

    /**
     * @param PackageName the PackageName to set
     */
    public void setPackageName(String PackageName) {
        this.PackageName = PackageName;
    }

    /**
     * @return the ExpiryDate
     */
    public String getExpiryDate() {
        return ExpiryDate;
    }

    /**
     * @param ExpiryDate the ExpiryDate to set
     */
    public void setExpiryDate(String ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    /**
     * @return the ClientName
     */
    public String getClientName() {
        return ClientName;
    }

    /**
     * @param ClientName the ClientName to set
     */
    public void setClientName(String ClientName) {
        this.ClientName = ClientName;
    }

    /**
     * @return the Start_date
     */
    public Date getStart_date() {
        return Start_date;
    }

    /**
     * @param Start_date the Start_date to set
     */
    public void setStart_date(Date Start_date) {
        this.Start_date = Start_date;
    }

    /**
     * @return the Expire_date
     */
    public Date getExpire_date() {
        return Expire_date;
    }

    /**
     * @param Expire_date the Expire_date to set
     */
    public void setExpire_date(Date Expire_date) {
        this.Expire_date = Expire_date;
    }

    /**
     * @return the Last_renew_date
     */
    public Date getLast_renew_date() {
        return Last_renew_date;
    }

    /**
     * @param Last_renew_date the Last_renew_date to set
     */
    public void setLast_renew_date(Date Last_renew_date) {
        this.Last_renew_date = Last_renew_date;
    }

    /**
     * @return the Add_date
     */
    public Date getAdd_date() {
        return Add_date;
    }

    /**
     * @param Add_date the Add_date to set
     */
    public void setAdd_date(Date Add_date) {
        this.Add_date = Add_date;
    }

    /**
     * @return the Last_edit_date
     */
    public Date getLast_edit_date() {
        return Last_edit_date;
    }

    /**
     * @param Last_edit_date the Last_edit_date to set
     */
    public void setLast_edit_date(Date Last_edit_date) {
        this.Last_edit_date = Last_edit_date;
    }

    /**
     * @return the License_expire_code
     */
    public String getLicense_expire_code() {
        return License_expire_code;
    }

    /**
     * @param License_expire_code the License_expire_code to set
     */
    public void setLicense_expire_code(String License_expire_code) {
        this.License_expire_code = License_expire_code;
    }

    /**
     * @return the Transactor_id
     */
    public long getTransactor_id() {
        return Transactor_id;
    }

    /**
     * @param Transactor_id the Transactor_id to set
     */
    public void setTransactor_id(long Transactor_id) {
        this.Transactor_id = Transactor_id;
    }

    /**
     * @return the Start_date2
     */
    public Date getStart_date2() {
        return Start_date2;
    }

    /**
     * @param Start_date2 the Start_date2 to set
     */
    public void setStart_date2(Date Start_date2) {
        this.Start_date2 = Start_date2;
    }

    /**
     * @return the Wtl_app_name
     */
    public String getWtl_app_name() {
        return Wtl_app_name;
    }

    /**
     * @param Wtl_app_name the Wtl_app_name to set
     */
    public void setWtl_app_name(String Wtl_app_name) {
        this.Wtl_app_name = Wtl_app_name;
    }

}
