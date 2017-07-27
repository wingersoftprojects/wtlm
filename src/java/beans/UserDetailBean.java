package beans;

import connections.DBConnection;
import entities.UserDetail;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utilities.GeneralUserSetting;
import utilities.Security;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author btwesigye
 */
@ManagedBean
@SessionScoped
public class UserDetailBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<UserDetail> UserDetails;
    private List<UserDetail> UserDetailObjectList;
    private String ActionMessage = null;
    private UserDetail SelectedUserDetail = null;
    private int SelectedUserDetailId;
    private String SearchUserName = "";

    public UserDetail findUserDetail(int aUserDetailId) {
        String sql = "{call sp_search_user_detail_by_id(?)}";
        ResultSet rs = null;
        try (
                Connection conn = DBConnection.getINTER_BRANCH_MySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, aUserDetailId);
            rs = ps.executeQuery();
            if (rs.next()) {
                UserDetail userdetail = new UserDetail();
                userdetail.setUserDetailId(rs.getInt("user_detail_id"));
                userdetail.setUserName(rs.getString("user_name"));
                userdetail.setUserPassword(Security.Decrypt(rs.getString("user_password")));
                userdetail.setUserPasswordConfirm(Security.Decrypt(rs.getString("user_password")));
                userdetail.setFirstName(rs.getString("first_name"));
                userdetail.setSecondName(rs.getString("second_name"));
                userdetail.setThirdName(rs.getString("third_name"));
                userdetail.setIsUserLocked(rs.getString("is_user_locked"));
                userdetail.setIsUserGenAdmin(rs.getString("is_user_gen_admin"));
                userdetail.setUserCategoryId(rs.getInt("user_category_id"));
                //userdetail.setUserImgUrl(rs.getString("user_img_url"));
                return userdetail;
            } else {
                return null;
            }
        } catch (SQLException se) {
            System.err.println(se.getMessage());
            return null;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public UserDetail getUserDetail(int aUserDetailId) {
        String sql = "{call sp_search_user_detail_by_id(?)}";
        ResultSet rs = null;
        try (
                Connection conn = DBConnection.getINTER_BRANCH_MySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, aUserDetailId);
            rs = ps.executeQuery();
            if (rs.next()) {
                UserDetail userdetail = new UserDetail();
                userdetail.setUserDetailId(rs.getInt("user_detail_id"));
                userdetail.setUserName(rs.getString("user_name"));
                userdetail.setUserPassword(Security.Decrypt(rs.getString("user_password")));
                userdetail.setUserPasswordConfirm(Security.Decrypt(rs.getString("user_password")));
                userdetail.setFirstName(rs.getString("first_name"));
                userdetail.setSecondName(rs.getString("second_name"));
                userdetail.setThirdName(rs.getString("third_name"));
                userdetail.setIsUserLocked(rs.getString("is_user_locked"));
                userdetail.setIsUserGenAdmin(rs.getString("is_user_gen_admin"));
                userdetail.setUserCategoryId(rs.getInt("user_category_id"));
                //userdetail.setUserImgUrl(rs.getString("user_img_url"));
                return userdetail;
            } else {
                return null;
            }
        } catch (SQLException se) {
            System.err.println(se.getMessage());
            return null;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }

    }

    public UserDetail getUserDetailByUserName(String UserName) {
        String sql = "{call sp_search_user_detail_by_username(?)}";
        ResultSet rs = null;
        try (
                Connection conn = DBConnection.getINTER_BRANCH_MySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, UserName);
            rs = ps.executeQuery();
            if (rs.next()) {
                UserDetail userdetail = new UserDetail();
                userdetail.setUserDetailId(rs.getInt("user_detail_id"));
                userdetail.setUserName(rs.getString("user_name"));
                userdetail.setUserPassword(Security.Decrypt(rs.getString("user_password")));
                userdetail.setUserPasswordConfirm(Security.Decrypt(rs.getString("user_password")));
                userdetail.setFirstName(rs.getString("first_name"));
                userdetail.setSecondName(rs.getString("second_name"));
                userdetail.setThirdName(rs.getString("third_name"));
                userdetail.setIsUserLocked(rs.getString("is_user_locked"));
                userdetail.setIsUserGenAdmin(rs.getString("is_user_gen_admin"));
                userdetail.setUserCategoryId(rs.getInt("user_category_id"));
                //userdetail.setUserImgUrl(rs.getString("user_img_url"));
                return userdetail;
            } else {
                return null;
            }
        } catch (SQLException se) {
            System.err.println(se.getMessage());
            return null;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public static int getSystemUserDetailId() {
        String sql = "{call sp_search_user_detail_by_username(?)}";
        ResultSet rs = null;
        try (
                Connection conn = DBConnection.getINTER_BRANCH_MySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, "system");
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("user_detail_id");
            } else {
                return 0;
            }
        } catch (SQLException se) {
            System.err.println(se.getMessage());
            return 0;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }

    public long getCountTotalActiveUserDetail() {
        String sql = "{call sp_search_user_detail_all_active()}";
        ResultSet rs = null;
        try (
                Connection conn = DBConnection.getINTER_BRANCH_MySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getLong("total_user_count");
            } else {
                return 0;
            }
        } catch (SQLException se) {
            System.err.println(se.getMessage());
            return 1000000;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }

    }

    public boolean isLicensePackageViolated(UserDetail aUserDetail, long PackageUsers) {
        long TotalActiveUsers = this.getCountTotalActiveUserDetail();
        if (aUserDetail.getUserDetailId() == 0) {//for new addition
            if (aUserDetail.getIsUserLocked().equals("Yes") && TotalActiveUsers > PackageUsers) {
                return true;
            } else if (aUserDetail.getIsUserLocked().equals("No") && (TotalActiveUsers + 1) > PackageUsers) {
                return true;
            } else {
                return false;
            }
        } else if (aUserDetail.getUserDetailId() > 0) {//for update
            if (aUserDetail.getIsUserLocked().equals("No")) {
                UserDetail UserDetailOld = new UserDetail();
                UserDetailOld = this.getUserDetail(aUserDetail.getUserDetailId());
                if (UserDetailOld.getIsUserLocked().equals("Yes") && (TotalActiveUsers + 1) > PackageUsers) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return true;
        }
    }


    public void displayUserDetail(UserDetail UserDetailFrom, UserDetail UserDetailTo) {
        UserDetailTo.setUserDetailId(UserDetailFrom.getUserDetailId());
        UserDetailTo.setUserName(UserDetailFrom.getUserName());
        UserDetailTo.setUserPassword(UserDetailFrom.getUserPassword());
        UserDetailTo.setUserPasswordConfirm(UserDetailFrom.getUserPasswordConfirm());
        UserDetailTo.setFirstName(UserDetailFrom.getFirstName());
        UserDetailTo.setSecondName(UserDetailFrom.getSecondName());
        UserDetailTo.setThirdName(UserDetailFrom.getThirdName());
        UserDetailTo.setIsUserLocked(UserDetailFrom.getIsUserLocked());
        UserDetailTo.setIsUserGenAdmin(UserDetailFrom.getIsUserGenAdmin());
        UserDetailTo.setUserCategoryId(UserDetailFrom.getUserCategoryId());
        //UserDetailTo.setUserImgUrl(UserDetailFrom.getUserImgUrl());
    }

    public void clearUserDetail(UserDetail userdetail) {
        if (userdetail != null) {
            userdetail.setUserDetailId(0);
            userdetail.setUserName("");
            userdetail.setUserPassword("");
            userdetail.setUserPasswordConfirm("");
            userdetail.setFirstName("");
            userdetail.setSecondName("");
            userdetail.setThirdName("");
            userdetail.setIsUserLocked("");
            userdetail.setIsUserGenAdmin("");
            userdetail.setUserCategoryId(0);
            //userdetail.setUserImgUrl("");
        }
    }

    public void clearUserDetailChange(UserDetail userdetail) {
        userdetail.setOldUserPassword("");
        userdetail.setNewUserPassword("");
        userdetail.setNewUserPasswordConfirm("");
    }

    /**
     * @param aSearchName
     * @return the UserDetails
     */
    public List<UserDetail> getUserDetailsByNames(String aSearchName) {
        String sql;
        sql = "{call sp_search_user_detail_by_names(?)}";
        ResultSet rs = null;
        UserDetails = new ArrayList<UserDetail>();
        try (
                Connection conn = DBConnection.getINTER_BRANCH_MySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, aSearchName);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserDetail userdetail = new UserDetail();
                userdetail.setUserDetailId(rs.getInt("user_detail_id"));
                userdetail.setUserName(rs.getString("user_name"));
                userdetail.setUserPassword(Security.Decrypt(rs.getString("user_password")));
                userdetail.setUserPasswordConfirm(Security.Decrypt(rs.getString("user_password")));
                userdetail.setFirstName(rs.getString("first_name"));
                userdetail.setSecondName(rs.getString("second_name"));
                userdetail.setThirdName(rs.getString("third_name"));
                userdetail.setIsUserLocked(rs.getString("is_user_locked"));
                userdetail.setIsUserGenAdmin(rs.getString("is_user_gen_admin"));
                userdetail.setUserCategoryId(rs.getInt("user_category_id"));
                //userdetail.setUserImgUrl(rs.getString("user_img_url"));
                UserDetails.add(userdetail);
            }
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        return UserDetails;
    }

    public List<UserDetail> getUserDetails() {
        String sql;
        sql = "{call sp_search_user_detail_by_none()}";
        ResultSet rs = null;
        UserDetails = new ArrayList<UserDetail>();
        try (
                Connection conn = DBConnection.getINTER_BRANCH_MySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery();
            while (rs.next()) {
                UserDetail userdetail = new UserDetail();
                userdetail.setUserDetailId(rs.getInt("user_detail_id"));
                userdetail.setUserName(rs.getString("user_name"));
                userdetail.setUserPassword(Security.Decrypt(rs.getString("user_password")));
                userdetail.setUserPasswordConfirm(Security.Decrypt(rs.getString("user_password")));
                userdetail.setFirstName(rs.getString("first_name"));
                userdetail.setSecondName(rs.getString("second_name"));
                userdetail.setThirdName(rs.getString("third_name"));
                userdetail.setIsUserLocked(rs.getString("is_user_locked"));
                userdetail.setIsUserGenAdmin(rs.getString("is_user_gen_admin"));
                userdetail.setUserCategoryId(rs.getInt("user_category_id"));
                //userdetail.setUserImgUrl(rs.getString("user_img_url"));
                UserDetails.add(userdetail);
            }
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        return UserDetails;
    }   
    /**
     * @param UserDetails the UserDetails to set
     */
    public void setUserDetails(List<UserDetail> UserDetails) {
        this.UserDetails = UserDetails;
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
     * @return the SelectedUserDetail
     */
    public UserDetail getSelectedUserDetail() {
        return SelectedUserDetail;
    }

    /**
     * @param SelectedUserDetail the SelectedUserDetail to set
     */
    public void setSelectedUserDetail(UserDetail SelectedUserDetail) {
        this.SelectedUserDetail = SelectedUserDetail;
    }

    /**
     * @return the SelectedUserDetailId
     */
    public int getSelectedUserDetailId() {
        return SelectedUserDetailId;
    }

    /**
     * @param SelectedUserDetailId the SelectedUserDetailId to set
     */
    public void setSelectedUserDetailId(int SelectedUserDetailId) {
        this.SelectedUserDetailId = SelectedUserDetailId;
    }

    /**
     * @return the SearchUserName
     */
    public String getSearchUserName() {
        return SearchUserName;
    }

    /**
     * @param SearchUserName the SearchUserName to set
     */
    public void setSearchUserName(String SearchUserName) {
        this.SearchUserName = SearchUserName;
    }

    /**
     * @return the UserDetailObjectList
     */
    public List<UserDetail> getUserDetailObjectList(String Query) {
        String sql;
        sql = "{call sp_search_user_detail_by_names(?)}";
        ResultSet rs = null;
        UserDetailObjectList = new ArrayList<UserDetail>();
        try (
                Connection conn = DBConnection.getINTER_BRANCH_MySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, Query.trim());
            rs = ps.executeQuery();
            while (rs.next()) {
                UserDetail userdetail = new UserDetail();
                userdetail.setUserDetailId(rs.getInt("user_detail_id"));
                userdetail.setUserName(rs.getString("user_name"));
                userdetail.setUserPassword(Security.Decrypt(rs.getString("user_password")));
                userdetail.setUserPasswordConfirm(Security.Decrypt(rs.getString("user_password")));
                userdetail.setFirstName(rs.getString("first_name"));
                userdetail.setSecondName(rs.getString("second_name"));
                userdetail.setThirdName(rs.getString("third_name"));
                userdetail.setIsUserLocked(rs.getString("is_user_locked"));
                userdetail.setIsUserGenAdmin(rs.getString("is_user_gen_admin"));
                userdetail.setUserCategoryId(rs.getInt("user_category_id"));
//                userdetail.setUserImgUrl(rs.getString("user_img_url"));
                UserDetailObjectList.add(userdetail);
            }
        } catch (SQLException se) {
            System.err.println(se.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
        return UserDetailObjectList;
    }

    /**
     * @param UserDetailObjectList the UserDetailObjectList to set
     */
    public void setUserDetailObjectList(List<UserDetail> UserDetailObjectList) {
        this.UserDetailObjectList = UserDetailObjectList;
    }

}
