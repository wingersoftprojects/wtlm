/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import entities.Task_category;
import entities.Task_detail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author philp
 */
@ManagedBean
@RequestScoped
public class Task_categoryBean {

    PreparedStatement ps = null;
    Connection conn = null;
    int i = 0;
    ResultSet rs = null;
    private Task_category Task_categoryObject;

    /**
     * Creates a new instance of Task_categoryBean
     */
    public Task_categoryBean() {
    }
    public void save_task_category(Task_category task_category){
        try {

            conn = DBConnection.getMySQLConnection();
            String sql = "INSERT INTO task_category(task_category_name) VALUES(?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, task_category.getTask_category_name());            
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
    public void updateTask_category(Task_category task_category){
        try {

            conn = DBConnection.getMySQLConnection();
            String sql = "UPDATE task_category SET task_category_name=? WHERE task_category_id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, task_category.getTask_category_name());            
            ps.setInt(2, task_category.getTask_category_id());            
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
        public List<Task_category> getTask_categorys() throws Exception {
        List<Task_category> task_categorys = new ArrayList<>();

        try {                       
            //get database connection
            conn = DBConnection.getMySQLConnection();
            if (conn == null) {
                throw new SQLException("Failed to establish database connection");
            }
            
            String sql = "SELECT * FROM task_category";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            
            while (rs.next()) {
                Task_category tc = new Task_category();
                tc.setTask_category_id(rs.getInt("task_category_id"));
                tc.setTask_category_name(rs.getString("task_category_name"));

                task_categorys.add(tc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return task_categorys;
    }

    /**
     * @return the Task_categoryObject
     */
    public Task_category getTask_categoryObject() {
        return Task_categoryObject;
    }

    /**
     * @param Task_categoryObject the Task_categoryObject to set
     */
    public void setTask_categoryObject(Task_category Task_categoryObject) {
        this.Task_categoryObject = Task_categoryObject;
    }

}
