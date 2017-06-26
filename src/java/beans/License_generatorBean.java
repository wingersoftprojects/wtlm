/*
 * To change this license header, choose License_detail Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.License_detail;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import utilities.Security;

/**
 *
 * @author philp
 */
@ManagedBean
@RequestScoped
public class License_generatorBean {
    private String ActionMessage="";
    private String EncryptedKey="";
    private String DecryptedKey="";
    
    public void GenerateLicense_detailKey(License_detail aLicense_detail){
        String License_detailString="";
        if(aLicense_detail!=null){
            if(License_generatorBean.IsValidClientId(aLicense_detail.getClientId()) && License_generatorBean.IsValidPackageName(aLicense_detail.getPackageName()) && License_generatorBean.IsValidClientName(aLicense_detail.getClientName()) && License_generatorBean.IsValidExpiryDate(aLicense_detail.getExpiryDate())){
                License_detailString=aLicense_detail.getExpiryDate() + "" + aLicense_detail.getClientId() + "" + aLicense_detail.getPackageName() + "" + aLicense_detail.getClientName();
            }else{
                License_detailString="";
            }
        }
        if(License_detailString.length()>=27){
            this.EncryptedKey=Security.Encrypt(License_detailString);
        }else{
            this.EncryptedKey="";
        }
    }
    public void DisplayLicense_detailKey(String aEncryptedLicense_detailKey){
        License_detail aLicense_detail=null;
        String aDecryptedLicense_detailKey="";
        this.DecryptedKey="";
        if(aEncryptedLicense_detailKey.length()>=124){
            aDecryptedLicense_detailKey=Security.Decrypt(aEncryptedLicense_detailKey);
            //System.out.println(aDecryptedLicense_detailKey);
            if(aDecryptedLicense_detailKey.length()>=27){
                aLicense_detail=new License_detail();
                aLicense_detail.setExpiryDate(aDecryptedLicense_detailKey.substring(0, 8));
                aLicense_detail.setClientId(aDecryptedLicense_detailKey.substring(8, 16));
                aLicense_detail.setPackageName(aDecryptedLicense_detailKey.substring(16, 24));
                aLicense_detail.setClientName(aDecryptedLicense_detailKey.substring(24));
                if(License_generatorBean.IsValidClientId(aLicense_detail.getClientId()) && License_generatorBean.IsValidPackageName(aLicense_detail.getPackageName()) && License_generatorBean.IsValidClientName(aLicense_detail.getClientName()) && License_generatorBean.IsValidExpiryDate(aLicense_detail.getExpiryDate())){
                    
                }else{
                    FacesContext.getCurrentInstance().addMessage("Key", new FacesMessage("Invalid License_detail Key"));
                    this.DecryptedKey="";
                    aLicense_detail=null;
                }
            }else{
                FacesContext.getCurrentInstance().addMessage("Key", new FacesMessage("Invalid License_detail Key"));
                this.DecryptedKey="";
                aLicense_detail=null;
            }
        }else{
            FacesContext.getCurrentInstance().addMessage("Key", new FacesMessage("Invalid License_detail Key"));
            this.DecryptedKey="";
            aLicense_detail=null;
        }
        if(aLicense_detail!=null){
            this.DecryptedKey="CLIENT-ID:" + aLicense_detail.getClientId() + "    CLIENT-NAME:" + aLicense_detail.getClientName() + "    PACKAGE-NAME:" + aLicense_detail.getPackageName() + "    EXPIRY-DATE:" + aLicense_detail.getExpiryDate();
        }
    }
    
    public void clearLicense_detail(License_detail l){
        l.setClientId("");
        l.setClientName("");
        l.setExpiryDate("");
        l.setPackageName("");
    }
    
    public static boolean IsValidClientId(String aClientId) {
        if(aClientId.length()!=8 || !License_generatorBean.IsStringInteger(aClientId)){
            FacesContext.getCurrentInstance().addMessage("Key", new FacesMessage("Length of ClientId should be 8 Numeric Characters"));
            return false;
        }else{
            return true;
        }
    }
    public static boolean IsValidPackageName(String aPackageName) {
        if(aPackageName.length()!=8){
            FacesContext.getCurrentInstance().addMessage("Key", new FacesMessage("Length of Package Name should be 8 Characters"));
            return false;
        }else{
            return true;
        }
    }
    public static boolean IsValidClientName(String aClientName) {
        if(aClientName.length()<3){
            FacesContext.getCurrentInstance().addMessage("Key", new FacesMessage("Length of Client Name should be at least 3 Characters"));
            return false;
        }else{
            return true;
        }
    }
    public static boolean IsValidExpiryDate(String aExpiryDate) {
        if(aExpiryDate.length()!=8 || !License_generatorBean.IsStringInteger(aExpiryDate)){
            FacesContext.getCurrentInstance().addMessage("Key", new FacesMessage("Expiry Date should be in this format DDMMYYYY and Numeric ONLY"));
            return false;
        }else{
            if(Integer.parseInt(aExpiryDate.substring(0, 2))>31 || Integer.parseInt(aExpiryDate.substring(0, 2))<=0 || Integer.parseInt(aExpiryDate.substring(2, 4))>12 || Integer.parseInt(aExpiryDate.substring(2, 4))<=0 || Integer.parseInt(aExpiryDate.substring(4, 8))>9999 || Integer.parseInt(aExpiryDate.substring(4, 8))<2014){
                FacesContext.getCurrentInstance().addMessage("Key", new FacesMessage("Invalid Expiry Date"));
                return false;
            }else{
                return true;
            }
        }
    }
    public static boolean IsStringInteger(String s){
        try
        {
           int i = Integer.parseInt(s);
           return true;
        }
        catch (NumberFormatException ex)
        {
           return false;
        }
    }

    /**
     * @return the ActionMessage
     */
    public String getActionMessage() {
        return ActionMessage;
    }

    /**
     * @param ActionMessage the ActionMessage to set
     */
    public void setActionMessage(String ActionMessage) {
        this.ActionMessage = ActionMessage;
    }

    /**
     * @return the EncryptedKey
     */
    public String getEncryptedKey() {
        return EncryptedKey;
    }

    /**
     * @param EncryptedKey the EncryptedKey to set
     */
    public void setEncryptedKey(String EncryptedKey) {
        this.EncryptedKey = EncryptedKey;
    }

    /**
     * @return the DecryptedKey
     */
    public String getDecryptedKey() {
        return DecryptedKey;
    }

    /**
     * @param DecryptedKey the DecryptedKey to set
     */
    public void setDecryptedKey(String DecryptedKey) {
        this.DecryptedKey = DecryptedKey;
    }
    
}
