/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import entities.LoginSession;
import entities.UserDetail;
import java.io.Serializable;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author philp
 */
@ManagedBean
@SessionScoped
public class loginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ActionMessageSuccess = null;
    private String ActionMessageFailure = null;
    private UserDetail LoggedInUserDetail = null;
    private String Username;
    private String Password;

    /**
     * Creates a new instance of loginBean
     */
    public loginBean() {
    }

    public void login() {
        if (new DBConnection().isINTER_BRANCH_MySQLConnectionAvailable().equals("ON")) {
            UserDetailBean udb = new UserDetailBean();
            this.setLoggedInUserDetail(udb.getUserDetailByUserName(this.getUsername()));
            if (this.getLoggedInUserDetail() != null && this.getPassword().equals(this.getLoggedInUserDetail().getUserPassword()) && "No".equals(this.getLoggedInUserDetail().getIsUserLocked())) {
                //it means username and password are valid and un-locked
                    FacesContext context = FacesContext.getCurrentInstance();  
                    HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();  
                    HttpSession httpSession = request.getSession(true);  
                    //set LoggedIn/Current User in session
                    httpSession.setAttribute("CURRENT_USER", this.LoggedInUserDetail);
                    //first delete all un-logged out sessions of this user that are older than 12 hours
                    new LoginSessionBean().deleteOldUnloggedOutSessions();
                    
                    //---------------add login session to the session database---
                    LoginSession ls=new LoginSession();
                    ls.setUserDetailId(this.LoggedInUserDetail.getUserDetailId());
//                    ls.setStoreId(this.LoggedInStoreId);
                    ls.setSessionId(FacesContext.getCurrentInstance().getExternalContext().getSessionId(false));
                    
                    String aRemoteIp="";
                    String aRemoteHost="";
                    String aRemoteUser="";
                    
                    aRemoteIp = request.getHeader("X-FORWARDED-FOR");
                    if (aRemoteIp == null) {
                        aRemoteIp = request.getRemoteAddr();
                    }
                    ls.setRemoteIp(aRemoteIp);
                    
                    try{
                        aRemoteHost=request.getRemoteHost();
                        if(aRemoteHost==null){
                            aRemoteHost="";
                        }
                    }catch(NullPointerException npe){
                        aRemoteHost="";
                    }
                    ls.setRemoteHost(aRemoteHost);
                    
                    try{
                        aRemoteUser=request.getRemoteUser();
                        if(aRemoteUser==null){
                            aRemoteUser="";
                        }
                    }catch(NullPointerException npe){
                        aRemoteUser="";
                    }
                    ls.setRemoteUser(aRemoteUser);
                    
                    //System.out.println("SID:" + ls.getSessionId() + " UID:" + ls.getUserDetailId() + "Saved:" + new LoginSessionBean().saveLoginSession(ls));
                    if(new LoginSessionBean().saveLoginSession(ls)==1){
                        //added successfully
                    }

                //Navigate to the Menu or Home page
                FacesContext fc = FacesContext.getCurrentInstance();
                ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();               
                nav.performNavigation("home?faces-redirect=true");
            } else {
                this.setLoggedInUserDetail(null);
                this.setActionMessageSuccess("");
                this.setActionMessageFailure("Invalid Login");
                FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Invalid Login.. Try again"));
            }
        } else {
            this.setActionMessageSuccess("");
            this.setActionMessageFailure("Database Connection Failure");
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Failed to Establish Connection. Contact Database Admin"));
        }
    }
    public String logout() {
        return "login?faces-redirect=true";
    }
        public void redirectifnotloggedin() {
        if (LoggedInUserDetail != null) {
            logout();
            FacesContext fc = FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
            nav.performNavigation("login?faces-redirect=true");

        }
    }


    /**
     * @return the ActionMessageSuccess
     */
    public String getActionMessageSuccess() {
        return ActionMessageSuccess;
    }

    /**
     * @param ActionMessageSuccess the ActionMessageSuccess to set
     */
    public void setActionMessageSuccess(String ActionMessageSuccess) {
        this.ActionMessageSuccess = ActionMessageSuccess;
    }

    /**
     * @return the ActionMessageFailure
     */
    public String getActionMessageFailure() {
        return ActionMessageFailure;
    }

    /**
     * @param ActionMessageFailure the ActionMessageFailure to set
     */
    public void setActionMessageFailure(String ActionMessageFailure) {
        this.ActionMessageFailure = ActionMessageFailure;
    }

    /**
     * @return the LoggedInUserDetail
     */
    public UserDetail getLoggedInUserDetail() {
        return LoggedInUserDetail;
    }

    /**
     * @param LoggedInUserDetail the LoggedInUserDetail to set
     */
    public void setLoggedInUserDetail(UserDetail LoggedInUserDetail) {
        this.LoggedInUserDetail = LoggedInUserDetail;
    }

    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }
}
