/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import entities.Task_detail;
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
import javax.sql.DataSource;
import utilities.UtilityBean;

/**
 *
 * @author philp
 */
@ManagedBean
@SessionScoped
public class Task_detailBean {

    private Task_detail task_detail = new Task_detail();
    PreparedStatement ps = null;
    Connection conn = null;
    int i = 0;
    ResultSet rs = null;
    private List<Task_detail> Task_detailList;
    private Task_detail Task_detailObject;
    private int task_age;

    public Task_detail getTask_detail() {
        return task_detail;
    }

    public void setTask_detail(Task_detail task_detail) {
        this.task_detail = task_detail;
    }

    public Task_detailBean() {
        this.Task_detailObject = new Task_detail();
    }

    public String redirectEdit(Task_detail aTask_detail) {
        this.Task_detailObject = aTask_detail;
        return "task_detail?faces-redirect=true";
    }

    public void redirectView(Task_detail aTask_detail) {
        this.Task_detailObject = aTask_detail;

    }

    public String redirectNew() {
        this.Task_detailObject = new Task_detail();
        return "task_detail?faces-redirect=true";
    }

    public void insertTask_detail(Task_detail task_detail) {
        String sql = "";
        sql = "INSERT INTO task_detail(assigned_to,task_description,task_category_id,current_status,"
                + "priority,raised_by,raise_date,completed_by,"
                + "complete_date,comment,transactor_id,is_active,"
                + "is_deleted,add_date,add_by,last_edit_date,last_edit_by) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,'0000-00-00 00:00',?,?,?)";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            try {
                ps.setInt(1, task_detail.getAssigned_to());
            } catch (NullPointerException npe) {
                ps.setInt(1, 0);
            }
            try {
                ps.setString(2, task_detail.getTask_description());
            } catch (NullPointerException npe) {
                ps.setString(2, "");
            }
            try {
                ps.setInt(3, task_detail.getTask_category_id());
            } catch (NullPointerException npe) {
                ps.setInt(3, 0);
            }
            try {
                ps.setString(4, task_detail.getCurrent_status());
            } catch (NullPointerException npe) {
                ps.setString(4, "");
            }
            try {
                ps.setString(5, task_detail.getPriority());
            } catch (NullPointerException npe) {
                ps.setString(5, "");
            }
            try {
                ps.setString(6, task_detail.getRaised_by());
            } catch (NullPointerException npe) {
                ps.setString(6, "");
            }
            try {
                ps.setDate(7, new java.sql.Date(task_detail.getRaise_date().getTime()));
            } catch (NullPointerException npe) {
                ps.setDate(7, null);
            }
            try {
                ps.setInt(8, task_detail.getCompleted_by());
            } catch (NullPointerException npe) {
                ps.setInt(8, 0);
            }
            try {
                ps.setDate(9, new java.sql.Date(task_detail.getComplete_date().getTime()));
            } catch (NullPointerException npe) {
                ps.setDate(9, null);
            }
            try {
                ps.setString(10, task_detail.getComment());
            } catch (NullPointerException npe) {
                ps.setString(10, "");
            }
            try {
                ps.setLong(11, task_detail.getTransactor_id());
            } catch (NullPointerException npe) {
                ps.setLong(11, 0);
            }
            try {
                ps.setInt(12, task_detail.getIs_active());
            } catch (NullPointerException npe) {
                ps.setInt(12, 0);
            }
            try {
                ps.setInt(13, task_detail.getIs_deleted());
            } catch (NullPointerException npe) {
                ps.setInt(13, 0);
            }
            try {
                ps.setTimestamp(14, new java.sql.Timestamp(new UtilityBean().getCURRENT_SERVER_DATE().getTime()));
            } catch (NullPointerException npe) {
                ps.setDate(14, null);
            }
            try {
                ps.setInt(15, task_detail.getAdd_by());
            } catch (NullPointerException npe) {
                ps.setInt(15, 0);
            }
            try {
                ps.setDate(16, null);
            } catch (NullPointerException npe) {
                ps.setDate(16, null);
            }
            try {
                ps.setInt(17, 0);
            } catch (NullPointerException npe) {
                ps.setInt(17, 0);
            }
            i = ps.executeUpdate();
            this.clearTask_detail(task_detail);
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Saved succesfully"));
        } catch (SQLException se) {
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            se.printStackTrace();
        }
    }

    public void updateTask_detail(Task_detail task_detail) {
        String sql = "";
        sql = "UPDATE task_detail SET assigned_to=?,task_description=?,task_category_id=?,current_status=?,"
                + "priority=?,raised_by=?,raise_date=?,completed_by=?,"
                + "complete_date=?,comment=?,transactor_id=?,is_active=?,"
                + "is_deleted=?,last_edit_date=?,last_edit_by=? "
                + "WHERE task_detail_id=?";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            try {
                ps.setInt(1, task_detail.getAssigned_to());
            } catch (NullPointerException npe) {
                ps.setInt(1, 0);
            }
            try {
                ps.setString(2, task_detail.getTask_description());
            } catch (NullPointerException npe) {
                ps.setString(2, "");
            }
            try {
                ps.setInt(3, task_detail.getTask_category_id());
            } catch (NullPointerException npe) {
                ps.setInt(3, 0);
            }
            try {
                ps.setString(4, task_detail.getCurrent_status());
            } catch (NullPointerException npe) {
                ps.setString(4, "");
            }
            try {
                ps.setString(5, task_detail.getPriority());
            } catch (NullPointerException npe) {
                ps.setString(5, "");
            }
            try {
                ps.setString(6, task_detail.getRaised_by());
            } catch (NullPointerException npe) {
                ps.setString(6, "");
            }
            try {
                ps.setDate(7, new java.sql.Date(task_detail.getRaise_date().getTime()));
            } catch (NullPointerException npe) {
                ps.setDate(7, null);
            }
            try {
                ps.setInt(8, task_detail.getCompleted_by());
            } catch (NullPointerException npe) {
                ps.setInt(8, 0);
            }
            try {
                ps.setDate(9, new java.sql.Date(task_detail.getComplete_date().getTime()));
            } catch (NullPointerException npe) {
                ps.setDate(9, null);
            }
            try {
                ps.setString(10, task_detail.getComment());
            } catch (NullPointerException npe) {
                ps.setString(10, "");
            }
            try {
                ps.setLong(11, task_detail.getTransactor_id());
            } catch (NullPointerException npe) {
                ps.setLong(11, 0);
            }
            try {
                ps.setInt(12, task_detail.getIs_active());
            } catch (NullPointerException npe) {
                ps.setInt(12, 0);
            }
            try {
                ps.setInt(13, task_detail.getIs_deleted());
            } catch (NullPointerException npe) {
                ps.setInt(13, 0);
            }
            try {
                ps.setTimestamp(14, new java.sql.Timestamp(new UtilityBean().getCURRENT_SERVER_DATE().getTime()));
            } catch (NullPointerException npe) {
                ps.setDate(14, null);
            }
            try {
                ps.setInt(15, 0);
            } catch (NullPointerException npe) {
                ps.setInt(16, 0);
            }
            try {
                ps.setInt(16, task_detail.getTask_detail_id());
            } catch (NullPointerException npe) {
                ps.setInt(16, 0);
            }
            i = ps.executeUpdate();
            this.clearTask_detail(task_detail);
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Updated succesfully"));
        } catch (SQLException se) {
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            se.printStackTrace();
        }
    }

    public List<Task_detail> getTask_details() throws Exception {
        List<Task_detail> task_details = new ArrayList<>();
        String sql = "SELECT * FROM task_detail";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Task_detail td = new Task_detail();
                this.setTask_detailFromResultset(td, rs);
                task_details.add(td);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return task_details;
    }

    public void setTask_detailFromResultset(Task_detail aTask_detail, ResultSet rs) {
        try {
            aTask_detail.setTask_detail_id(rs.getInt("task_detail_id"));
            aTask_detail.setTask_description(rs.getString("task_description"));
            aTask_detail.setAssigned_to(rs.getInt("assigned_to"));
            aTask_detail.setTask_category_id(rs.getInt("task_category_id"));
            aTask_detail.setCurrent_status(rs.getString("current_status"));
            aTask_detail.setPriority(rs.getString("priority"));
            aTask_detail.setRaise_date(rs.getDate("raise_date"));
            aTask_detail.setRaised_by(rs.getString("raised_by"));
            aTask_detail.setComplete_date(rs.getDate("complete_date"));
            aTask_detail.setCompleted_by(rs.getInt("completed_by"));
            aTask_detail.setComment(rs.getString("comment"));
            aTask_detail.setTransactor_id(rs.getLong("transactor_id"));
            aTask_detail.setIs_active(rs.getInt("is_active"));
            aTask_detail.setIs_deleted(rs.getInt("is_deleted"));
            aTask_detail.setAdd_date(rs.getDate("add_date"));
            aTask_detail.setAdd_by(rs.getInt("add_by"));
            aTask_detail.setLast_edit_date(rs.getDate("last_edit_date"));
            aTask_detail.setLast_edit_by(rs.getInt("last_edit_by"));
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void clearTask_detail(Task_detail aTask_detail) {
        if (null != aTask_detail) {
            aTask_detail.setTask_detail_id(0);
            aTask_detail.setTask_description("");
            aTask_detail.setAssigned_to(0);
            aTask_detail.setTask_category_id(0);
            aTask_detail.setCurrent_status("");
            aTask_detail.setPriority("");
            aTask_detail.setRaise_date(null);
            aTask_detail.setRaised_by("");
            aTask_detail.setComplete_date(null);
            aTask_detail.setCompleted_by(0);
            aTask_detail.setComment("");
            aTask_detail.setTransactor_id(0);
            aTask_detail.setIs_active(0);
            aTask_detail.setIs_deleted(0);
            aTask_detail.setAdd_date(null);
            aTask_detail.setAdd_by(0);
            aTask_detail.setLast_edit_date(null);
            aTask_detail.setLast_edit_by(0);

        }
    }

    public void searchTask_detail(Task_detail aTask_detail) {
        ResultSet res = null;
        this.Task_detailList = new ArrayList<>();
        String sql = "SELECT * FROM task_detail WHERE is_deleted=0 AND is_active=1";
        String wheresql = "";
        String orderby = "";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            if (aTask_detail.getPriority().length() > 0) {
                wheresql = wheresql + " AND priority='" + aTask_detail.getPriority() + "'";
            }
            if (aTask_detail.getAssigned_to() > 0) {
                wheresql = wheresql + " AND assigned_to=" + aTask_detail.getAssigned_to();
            }
            if (aTask_detail.getCurrent_status().length() > 0) {
                wheresql = wheresql + " AND current_status='" + aTask_detail.getCurrent_status() + "'";
            }
            if (aTask_detail.getRaise_date() != null && aTask_detail.getRaise_date2() != null) {
                wheresql = wheresql + " AND raise_date BETWEEN '" + new java.sql.Date(aTask_detail.getRaise_date().getTime()) + "' AND '" + new java.sql.Date(aTask_detail.getRaise_date2().getTime()) + "'";
            }
            orderby = " ORDER BY raise_date DESC";
            sql = sql + wheresql + orderby;
            res = ps.executeQuery(sql);
            Task_detail td;
            while (res.next()) {
                td = new Task_detail();
                this.setTask_detailFromResultset(td, res);
                this.Task_detailList.add(td);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public int getTask_age() {
        return task_age;
    }

    public void setTask_age(int task_age) {
        this.task_age = task_age;
    }

    /**
     * @return the Task_detailList
     */
    public List<Task_detail> getTask_detailList() {
        return Task_detailList;
    }

    /**
     * @param Task_detailList the Task_detailList to set
     */
    public void setTask_detailList(List<Task_detail> Task_detailList) {
        this.Task_detailList = Task_detailList;
    }

    /**
     * @return the Task_detailObject
     */
    public Task_detail getTask_detailObject() {
        return Task_detailObject;
    }

    /**
     * @param Task_detailObject the Task_detailObject to set
     */
    public void setTask_detailObject(Task_detail Task_detailObject) {
        this.Task_detailObject = Task_detailObject;
    }

}
