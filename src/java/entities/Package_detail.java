/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author philp
 */

@ManagedBean
@SessionScoped
public class Package_detail {
    private static final long serialVersionUID = 1L;
    
    private int Package_detail_id;
    private String Package_detail_name;
    private float Quota_mbs;
    private float Bw_mbs;
    private int Emails;
    private int Ftp;
    private int Dbs;
    private String Other_details;

    public int getPackage_detail_id() {
        return Package_detail_id;
    }

    public void setPackage_detail_id(int Package_detail_id) {
        this.Package_detail_id = Package_detail_id;
    }

    public String getPackage_detail_name() {
        return Package_detail_name;
    }

    public void setPackage_detail_name(String Package_detail_name) {
        this.Package_detail_name = Package_detail_name;
    }

    /**
     * @return the Quota_mbs
     */
    public float getQuota_mbs() {
        return Quota_mbs;
    }

    /**
     * @param Quota_mbs the Quota_mbs to set
     */
    public void setQuota_mbs(float Quota_mbs) {
        this.Quota_mbs = Quota_mbs;
    }

    /**
     * @return the Bw_mbs
     */
    public float getBw_mbs() {
        return Bw_mbs;
    }

    /**
     * @param Bw_mbs the Bw_mbs to set
     */
    public void setBw_mbs(float Bw_mbs) {
        this.Bw_mbs = Bw_mbs;
    }

    /**
     * @return the Emails
     */
    public int getEmails() {
        return Emails;
    }

    /**
     * @param Emails the Emails to set
     */
    public void setEmails(int Emails) {
        this.Emails = Emails;
    }

    /**
     * @return the Ftp
     */
    public int getFtp() {
        return Ftp;
    }

    /**
     * @param Ftp the Ftp to set
     */
    public void setFtp(int Ftp) {
        this.Ftp = Ftp;
    }

    /**
     * @return the Dbs
     */
    public int getDbs() {
        return Dbs;
    }

    /**
     * @param Dbs the Dbs to set
     */
    public void setDbs(int Dbs) {
        this.Dbs = Dbs;
    }

    /**
     * @return the Other_details
     */
    public String getOther_details() {
        return Other_details;
    }

    /**
     * @param Other_details the Other_details to set
     */
    public void setOther_details(String Other_details) {
        this.Other_details = Other_details;
    }
    
    
    
}
