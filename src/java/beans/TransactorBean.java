package beans;

import connections.DBConnection;
import entities.Transactor;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
public class TransactorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Transactor> Transactors;
    private String ActionMessage = null;
    private String SearchTransactorNames = "";
    private Transactor SelectedTransactor;
    private Transactor SelectedBillTransactor;
    private Transactor SelectedSchemeTransactor;
    private List<Transactor> TransactorObjectList;
    private List<Transactor> ReportTransactors = new ArrayList<Transactor>();
    private List<Transactor> TransactorList;

    public Transactor findTransactor(Long TransactorId) {
        String sql = "{call sp_search_transactor_by_id(?)}";
        ResultSet rs = null;
        try (
                Connection conn = DBConnection.getINTER_BRANCH_MySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setLong(1, TransactorId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return this.getTransactorFromResultSet(rs);
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
    
    public Transactor getTransactorFromResultSet(ResultSet rs) {
        try {
            Transactor transactor = new Transactor();
            try {
                transactor.setTransactorId(rs.getLong("transactor_id"));
            } catch (NullPointerException npe) {
                transactor.setTransactorId(0);
            }
            try {
                transactor.setTransactorType(rs.getString("transactor_type"));
            } catch (NullPointerException npe) {
                transactor.setTransactorType("");
            }
            try {
                transactor.setTransactorNames(rs.getString("transactor_names"));
            } catch (NullPointerException npe) {
                transactor.setTransactorNames("");
            }
            try {
                transactor.setPhone(rs.getString("phone"));
            } catch (NullPointerException npe) {
                transactor.setPhone("");
            }
            try {
                transactor.setEmail(rs.getString("email"));
            } catch (NullPointerException npe) {
                transactor.setEmail("");
            }
            try {
                transactor.setWebsite(rs.getString("website"));
            } catch (NullPointerException npe) {
                transactor.setWebsite("");
            }
            try {
                transactor.setCpName(rs.getString("cpname"));
            } catch (NullPointerException npe) {
                transactor.setCpName("");
            }
            try {
                transactor.setCpTitle(rs.getString("cptitle"));
            } catch (NullPointerException npe) {
                transactor.setCpTitle("");
            }
            try {
                transactor.setCpPhone(rs.getString("cpphone"));
            } catch (NullPointerException npe) {
                transactor.setCpPhone("");
            }
            try {
                transactor.setCpEmail(rs.getString("cpemail"));
            } catch (NullPointerException npe) {
                transactor.setCpEmail("");
            }
            try {
                transactor.setPhysicalAddress(rs.getString("physical_address"));
            } catch (NullPointerException npe) {
                transactor.setPhysicalAddress("");
            }
            try {
                transactor.setTaxIdentity(rs.getString("tax_identity"));
            } catch (NullPointerException npe) {
                transactor.setTaxIdentity("");
            }
            try {
                transactor.setAccountDetails(rs.getString("account_details"));
            } catch (NullPointerException npe) {
                transactor.setAccountDetails("");
            }
            try {
                transactor.setCardNumber(rs.getString("card_number"));
            } catch (NullPointerException npe) {
                transactor.setCardNumber("");
            }
            try {
                transactor.setDOB(new Date(rs.getDate("dob").getTime()));
            } catch (NullPointerException npe) {
                transactor.setDOB(null);
            }
            try {
                transactor.setIsSuspended(rs.getString("is_suspended"));
            } catch (NullPointerException npe) {
                transactor.setIsSuspended("");
            }
            try {
                transactor.setSuspendedReason(rs.getString("suspended_reason"));
            } catch (NullPointerException npe) {
                transactor.setSuspendedReason("");
            }
            try {
                transactor.setCategory(rs.getString("category"));
            } catch (NullPointerException npe) {
                transactor.setCategory("");
            }
            try {
                transactor.setSex(rs.getString("sex"));
            } catch (NullPointerException npe) {
                transactor.setSex("");
            }
            try {
                transactor.setOccupation(rs.getString("occupation"));
            } catch (NullPointerException npe) {
                transactor.setOccupation("");
            }
            try {
                transactor.setLocCountry(rs.getString("loc_country"));
            } catch (NullPointerException npe) {
                transactor.setLocCountry("");
            }
            try {
                transactor.setLocDistrict(rs.getString("loc_district"));
            } catch (NullPointerException npe) {
                transactor.setLocDistrict("");
            }
            try {
                transactor.setLocTown(rs.getString("loc_town"));
            } catch (NullPointerException npe) {
                transactor.setLocTown("");
            }
            try {
                transactor.setFirstDate(new Date(rs.getDate("first_date").getTime()));
            } catch (NullPointerException npe) {
                transactor.setFirstDate(null);
            }

            try {
                transactor.setFileReference(rs.getString("file_reference"));
            } catch (NullPointerException npe) {
                transactor.setFileReference("");
            }
            try {
                transactor.setIdType(rs.getString("id_type"));
            } catch (NullPointerException npe) {
                transactor.setIdType("");
            }
            try {
                transactor.setIdNumber(rs.getString("id_number"));
            } catch (NullPointerException npe) {
                transactor.setIdNumber("");
            }
            try {
                transactor.setIdExpiryDate(new Date(rs.getDate("id_expiry_date").getTime()));
            } catch (NullPointerException npe) {
                transactor.setIdExpiryDate(null);
            }
            try {
                transactor.setTransactorRef(rs.getString("transactor_ref"));
            } catch (NullPointerException npe) {
                transactor.setTransactorRef("");
            }
            try {
                transactor.setTitle(rs.getString("title"));
            } catch (NullPointerException npe) {
                transactor.setTitle("");
            }
            try {
                transactor.setPosition(rs.getString("position"));
            } catch (NullPointerException npe) {
                transactor.setPosition("");
            }
            try {
                transactor.setMonthGrossPay(rs.getFloat("month_gross_pay"));
            } catch (NullPointerException npe) {
                transactor.setMonthGrossPay(0);
            }
            try {
                transactor.setMonthNetPay(rs.getFloat("month_net_pay"));
            } catch (NullPointerException npe) {
                transactor.setMonthNetPay(0);
            }
            return transactor;
        } catch (SQLException se) {
            return null;
        }
    }

    public Transactor getTransactor(long TransactorId) {
        String sql = "{call sp_search_transactor_by_id(?)}";
        ResultSet rs = null;
        try (
                Connection conn = DBConnection.getINTER_BRANCH_MySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setLong(1, TransactorId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return this.getTransactorFromResultSet(rs);
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

    public void clearTransactor(Transactor transactor) {
        if (transactor != null) {
            transactor.setTransactorId(0);
            transactor.setTransactorType("");
            transactor.setTransactorNames("");
            transactor.setPhone("");
            transactor.setEmail("");
            transactor.setWebsite("");
            transactor.setCpName("");
            transactor.setCpTitle("");
            transactor.setCpEmail("");
            transactor.setCpPhone("");
            transactor.setPhysicalAddress("");
            transactor.setTaxIdentity("");
            transactor.setAccountDetails("");
            transactor.setCardNumber("");
            transactor.setDOB(null);
            transactor.setIsSuspended("");
            transactor.setSuspendedReason("");
            transactor.setCategory("");
            transactor.setSex("");
            transactor.setOccupation("");
            transactor.setLocCountry("");
            transactor.setLocDistrict("");
            transactor.setLocTown("");
            transactor.setFirstDate(null);
            transactor.setFileReference("");
            transactor.setIdType("");
            transactor.setIdNumber("");
            transactor.setIdExpiryDate(null);
            transactor.setTransactorRef("");
            transactor.setTitle("");
            transactor.setPosition("");
            transactor.setMonthGrossPay(0);
            transactor.setMonthNetPay(0);
        }
    }

    

    public void initClearTransactor(Transactor transactor) {
        if (FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()) {
            // Skip ajax requests.
        } else {
            if (transactor != null) {
                transactor.setTransactorId(0);
                transactor.setTransactorType("");
                transactor.setTransactorNames("");
                transactor.setPhone("");
                transactor.setEmail("");
                transactor.setWebsite("");
                transactor.setCpName("");
                transactor.setCpTitle("");
                transactor.setCpEmail("");
                transactor.setCpPhone("");
                transactor.setPhysicalAddress("");
                transactor.setTaxIdentity("");
                transactor.setAccountDetails("");
                transactor.setCardNumber("");
                transactor.setDOB(null);
                transactor.setIsSuspended("");
                transactor.setSuspendedReason("");
                transactor.setCategory("");
                transactor.setSex("");
                transactor.setOccupation("");
                transactor.setLocCountry("");
                transactor.setLocDistrict("");
                transactor.setLocTown("");
                transactor.setFirstDate(null);
                transactor.setFileReference("");
                transactor.setIdType("");
                transactor.setIdNumber("");
                transactor.setIdExpiryDate(null);
                transactor.setTransactorRef("");
                transactor.setTitle("");
                transactor.setPosition("");
                transactor.setMonthGrossPay(0);
                transactor.setMonthNetPay(0);
            }
        }
    }

    public void clearSelectedTransactor() {
        this.clearTransactor(this.getSelectedTransactor());
    }

    public void clearSelectedBillTransactor() {
        this.clearTransactor(this.getSelectedBillTransactor());
    }

    public List<Transactor> getTransactors() {
        String sql;
        sql = "{call sp_search_transactor_by_name(?)}";
        ResultSet rs = null;
        Transactors = new ArrayList<Transactor>();
        try (
                Connection conn = DBConnection.getINTER_BRANCH_MySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, this.getSearchTransactorNames());
            rs = ps.executeQuery();
            while (rs.next()) {
                Transactors.add(this.getTransactorFromResultSet(rs));
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
        return Transactors;
    }

    public List<Transactor> getTransactorsByNameType(String aName, String aType) {
        String sql;
        sql = "{call sp_search_transactor_by_name_type(?,?)}";
        ResultSet rs = null;
        List<Transactor> NewTransactors = new ArrayList<Transactor>();
        try (
                Connection conn = DBConnection.getINTER_BRANCH_MySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, aName);
            ps.setString(2, aType);
            rs = ps.executeQuery();
            while (rs.next()) {
                NewTransactors.add(this.getTransactorFromResultSet(rs));
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
        return NewTransactors;
    }

    public void setTransactors(List<Transactor> Transactors) {
        this.Transactors = Transactors;
    }

    /**
     * @param Query
     * @return the TransactorStringList
     */
    public List<String> getTransactorStringList(String Query) {
        String sql;
        sql = "{call sp_search_transactor_by_name(?)}";
        ResultSet rs = null;
        List<String> TransactorStringList = new ArrayList<String>();
        try (
                Connection conn = DBConnection.getINTER_BRANCH_MySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, Query);
            rs = ps.executeQuery();
            while (rs.next()) {
                TransactorStringList.add(rs.getString("transactor_names"));
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
        return TransactorStringList;
    }

    /**
     * @param Query
     * @return the TransactorObjectList
     */
    public List<Transactor> getTransactorObjectList(String Query) {
        String sql;
        sql = "{call sp_search_transactor_by_name(?)}";
        ResultSet rs = null;
        TransactorObjectList = new ArrayList<Transactor>();
        try (
                Connection conn = DBConnection.getINTER_BRANCH_MySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, Query);
            rs = ps.executeQuery();
            while (rs.next()) {
                TransactorObjectList.add(this.getTransactorFromResultSet(rs));
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
        return TransactorObjectList;
    }

    public List<Transactor> getReportTransactors(Transactor aTransactor, boolean RETRIEVE_REPORT) {
        String sql = "{call sp_report_transactor(?)}";
        ResultSet rs = null;
        this.ReportTransactors.clear();
        if (aTransactor != null && RETRIEVE_REPORT == true) {
            try (
                    Connection conn = DBConnection.getINTER_BRANCH_MySQLConnection();
                    PreparedStatement ps = conn.prepareStatement(sql);) {
                ps.setString(1, aTransactor.getTransactorType());
                rs = ps.executeQuery();
                while (rs.next()) {
                    this.ReportTransactors.add(this.getTransactorFromResultSet(rs));
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
        } else {
            this.ReportTransactors.clear();
        }
        return this.ReportTransactors;
    }

    public void reportTransactors(String aTransactorType) {
        String sql = "{call sp_report_transactor(?)}";
        ResultSet rs = null;
        this.TransactorList = new ArrayList<>();
        if (aTransactorType.length() > 0) {
            try (
                    Connection conn = DBConnection.getINTER_BRANCH_MySQLConnection();
                    PreparedStatement ps = conn.prepareStatement(sql);) {
                ps.setString(1, aTransactorType);
                rs = ps.executeQuery();
                while (rs.next()) {
                    this.TransactorList.add(this.getTransactorFromResultSet(rs));
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
        }
    }

    public long getReportTransactorsCount() {
        return this.ReportTransactors.size();
    }

    /**
     * @param TransactorObjectList the TransactorObjectList to set
     */
    public void setTransactorObjectList(List<Transactor> TransactorObjectList) {
        this.TransactorObjectList = TransactorObjectList;
    }

    /**
     * @return the SearchTransactorNames
     */
    public String getSearchTransactorNames() {
        return SearchTransactorNames;
    }

    /**
     * @param SearchTransactorNames the SearchTransactorNames to set
     */
    public void setSearchTransactorNames(String SearchTransactorNames) {
        this.SearchTransactorNames = SearchTransactorNames;
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

    /**
     * @return the SelectedBillTransactor
     */
    public Transactor getSelectedBillTransactor() {
        return SelectedBillTransactor;
    }

    /**
     * @param SelectedBillTransactor the SelectedBillTransactor to set
     */
    public void setSelectedBillTransactor(Transactor SelectedBillTransactor) {
        this.SelectedBillTransactor = SelectedBillTransactor;
    }

    /**
     * @return the SelectedSchemeTransactor
     */
    public Transactor getSelectedSchemeTransactor() {
        return SelectedSchemeTransactor;
    }

    /**
     * @param SelectedSchemeTransactor the SelectedSchemeTransactor to set
     */
    public void setSelectedSchemeTransactor(Transactor SelectedSchemeTransactor) {
        this.SelectedSchemeTransactor = SelectedSchemeTransactor;
    }

    /**
     * @return the TransactorList
     */
    public List<Transactor> getTransactorList() {
        return TransactorList;
    }

    /**
     * @param TransactorList the TransactorList to set
     */
    public void setTransactorList(List<Transactor> TransactorList) {
        this.TransactorList = TransactorList;
    }
}
