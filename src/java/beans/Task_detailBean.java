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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.sql.DataSource;

/**
 *
 * @author philp
 */
@ManagedBean
@RequestScoped
public class Task_detailBean {

    PreparedStatement ps = null;
    Connection conn = null;
    int i = 0;
    ResultSet rs = null;
    private DataSource ds;

    public Task_detailBean() {
    }

    public void saveTask_detail(Task_detail task_detail) {
        String sql = "";
        sql = "INSERT INTO task_detail(assigned_to,task_description,task_category_id,current_status,priority,raised_by,raise_date,is_active,is_deleted,add_date,add_by) VALUES(?,?,?,?,?,?,?,?,0,now(),1)";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            Task_detail task_detail1 = new Task_detail();
            //conn = DBConnection.getMySQLConnection();
            //ps = conn.prepareStatement(sql);
            ps.setInt(1, task_detail.getAssigned_to());
            ps.setString(2, task_detail.getTask_description());
            ps.setInt(3, task_detail.getTask_category_id());
            ps.setString(4, task_detail.getCurrent_status());
            ps.setString(5, task_detail.getPriority());
            ps.setString(6, task_detail.getRaised_by());
            ps.setDate(7, new java.sql.Date(task_detail.getRaise_date().getTime()));
            ps.setInt(8, task_detail.getIs_active());
            i = ps.executeUpdate();
            this.clearTask_detail(task_detail);
            System.out.println("Added succesfully!!!");
        } catch (SQLException se) {
            se.printStackTrace();
        }

    }

    public List<Task_detail> getTask_details() throws Exception {
        List<Task_detail> task_details = new ArrayList<>();
        String sql = "SELECT * FROM task_detail";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs=ps.executeQuery();
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
