/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connections.DBConnection;
import entities.Task_category;
import entities.Task_category;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author philp
 */
@ManagedBean
@SessionScoped
public class Task_categoryBean implements Serializable{
    private static final long serialVersionUID = 1L;

    private Task_category task_category = new Task_category();
    PreparedStatement ps = null;
    Connection conn = null;
    int i = 0;
    ResultSet rs = null;
    private List<Task_category> Task_categoryList;
    private Task_category Task_categoryObject;

    public Task_category getTask_category() {
        return task_category;
    }

    public void setTask_category(Task_category task_category) {
        this.task_category = task_category;
    }

    public Task_categoryBean() {
        this.Task_categoryObject = new Task_category();
    }

    public String redirectEdit(Task_category aTask_category) {
        this.Task_categoryObject = aTask_category;
        return "task_category?faces-redirect=true";
    }

    public String redirectNew() {
        this.Task_categoryObject = new Task_category();
        return "task_category?faces-redirect=true";
    }

    public void insertTask_category(Task_category task_category) {
        String sql = "";
        sql = "INSERT INTO task_category(task_category_name) VALUES(?)";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            try {
                ps.setString(1, task_category.getTask_category_name());
                i = ps.executeUpdate();
                this.clearTask_category(task_category);
                FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Saved succesfully"));
            } catch (NullPointerException npe) {
                FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            }
        } catch (SQLException se) {
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            se.printStackTrace();
        }
    }

    public void updateTask_category(Task_category task_category) {
        String sql = "";
        sql = "UPDATE task_category SET task_category_name=? WHERE task_category_id=?";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            try {
                ps.setString(1, task_category.getTask_category_name());
            } catch (NullPointerException npe) {
                ps.setString(1, "");
            }
            try {
                ps.setInt(2, task_category.getTask_category_id());
            } catch (NullPointerException npe) {
                ps.setInt(2, 0);
            }
            i = ps.executeUpdate();
            this.clearTask_category(task_category);
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Updated succesfully"));
        } catch (SQLException se) {
            FacesContext.getCurrentInstance().addMessage("Save", new FacesMessage("Error occured..."));
            se.printStackTrace();
        }
    }

    public List<Task_category> getTask_categorys() throws Exception {
        List<Task_category> task_categorys = new ArrayList<>();
        String sql = "SELECT * FROM task_category";
        try (
                Connection conn = DBConnection.getMySQLConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Task_category tc = new Task_category();
                this.setTask_categoryFromResultset(tc, rs);
                task_categorys.add(tc);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return task_categorys;
    }

    public void setTask_categoryFromResultset(Task_category aTask_category, ResultSet rs) {
        try {
            aTask_category.setTask_category_id(rs.getInt("task_category_id"));
            aTask_category.setTask_category_name(rs.getString("task_category_name"));

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void clearTask_category(Task_category aTask_category) {
        if (null != aTask_category) {
            aTask_category.setTask_category_id(0);
            aTask_category.setTask_category_name("");

        }
    }

    /**
     * @return the Task_categoryList
     */
    public List<Task_category> getTask_categoryList() {
        return Task_categoryList;
    }

    /**
     * @param Task_categoryList the Task_categoryList to set
     */
    public void setTask_categoryList(List<Task_category> Task_categoryList) {
        this.Task_categoryList = Task_categoryList;
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
