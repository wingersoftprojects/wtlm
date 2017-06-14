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
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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

    PreparedStatement ps = null;
    Connection conn = null;
    int i = 0;
    ResultSet rs = null;
    private DataSource ds;

    public Task_detailBean() {
    }

    public void insertTask_detail(Task_detail task_detail) {
        String sql = "";
        sql = "INSERT INTO task_detail(assigned_to,task_description,task_category_id,current_status,"
                + "priority,raised_by,raise_date,completed_by,"
                + "complete_date,comment,transactor_id,is_active,"
                + "is_deleted,add_date,add_by,last_edit_date,last_edit_by) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
        sql = "UPDATE task_detail SET "
                + "assigned_to=?,task_description=?,task_category_id=?,current_status=?,"
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
            rs = ps.executeQuery();
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
            aTask_detail.setAssigned_to(rs.getInt("assigned_to"));
            aTask_detail.setTask_category_id(rs.getInt("task_category_id"));
            aTask_detail.setCurrent_status(rs.getString("current_status"));
            aTask_detail.setPriority(rs.getString("priority"));
            aTask_detail.setRaise_date(rs.getDate("raise_date"));
            aTask_detail.setRaised_by(rs.getString("raised_by"));
            aTask_detail.setIs_active(rs.getInt("is_active"));
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void clearTask_detail(Task_detail aTask_detail) {
        if (null != aTask_detail) {
            aTask_detail.setTask_detail_id(0);
            aTask_detail.setAssigned_to(0);
            aTask_detail.setTask_description("");
            aTask_detail.setTask_category_id(0);
            aTask_detail.setCurrent_status("");
            aTask_detail.setPriority("");
            aTask_detail.setRaise_date(null);
            aTask_detail.setRaised_by("");
            aTask_detail.setIs_active(0);
        }
    }

}
