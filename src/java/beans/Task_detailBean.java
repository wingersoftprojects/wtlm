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

    public void save_task(Task_detail task_detail) {
        try {
            Task_detail task_detail1 = new Task_detail();
            conn = DBConnection.getMySQLConnection();
            String sql = "INSERT INTO task_detail(assigned_to,task_description,task_category_id,current_status,priority,raised_by,raise_date,is_active,is_deleted,add_date,add_by) VALUES(?,?,?,?,?,?,?,?,0,now(),1)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, task_detail.getAssigned_to());
            ps.setString(2, task_detail.getTask_description());
            ps.setInt(3, task_detail.getTask_category_id());
            ps.setString(4, task_detail.getCurrent_status());
            ps.setString(5, task_detail.getPriority());
            ps.setString(6, task_detail.getRaised_by());
            ps.setDate(7, new java.sql.Date(task_detail.getRaise_date().getTime()));
            ps.setInt(8, task_detail.getIs_active());

            i = ps.executeUpdate();
            System.out.println("Added succesfully!!!");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                conn.close();
                ps.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public List<Task_detail> getTask_details() throws Exception {
        List<Task_detail> task_details = new ArrayList<>();

        try {                       
            //get database connection
            conn = DBConnection.getMySQLConnection();
            if (conn == null) {
                throw new SQLException("Failed to establish database connection");
            }
            
            String sql = "SELECT * FROM task_detail";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            
            while (rs.next()) {
                Task_detail td = new Task_detail();
                td.setTask_detail_id(rs.getInt("task_detail_id"));
                td.setAssigned_to(rs.getInt("assigned_to"));
                td.setTask_category_id(rs.getInt("task_category_id"));
                td.setCurrent_status(rs.getString("current_status"));
                td.setPriority(rs.getString("priority"));
                td.setRaise_date(rs.getDate("raise_date"));
                td.setRaised_by(rs.getString("raised_by"));
                td.setIs_active(rs.getInt("is_active"));

                task_details.add(td);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return task_details;
    }

}
