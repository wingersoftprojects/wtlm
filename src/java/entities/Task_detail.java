/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author philp
 */
@ManagedBean
@SessionScoped
public class Task_detail {

    private static final long serialVersionUID = 1L;

    private int Task_detail_id;
    private int Assigned_to;
    private String Task_description;
    private int Task_category_id;
    private String Task_category_name;
    private String Current_status;
    private String Priority;
    private String Raised_by;
    private Date Raise_date;
    private int Completed_by;
    private Date Complete_date;
    private String Comment;
    private long Transactor_id;
    private String Is_active;
    private int Is_deleted;
    private Date Add_date;
    private int Add_by;
    private Date Last_edit_date;
    private int Last_edit_by;
    //not from table
    private Date Raise_date2;

    public int getTask_detail_id() {
        return Task_detail_id;
    }

    public void setTask_detail_id(int Task_detail_id) {
        this.Task_detail_id = Task_detail_id;
    }

    public int getAssigned_to() {
        return Assigned_to;
    }

    public void setAssigned_to(int Assigned_to) {
        this.Assigned_to = Assigned_to;
    }

    public String getTask_description() {
        return Task_description;
    }

    public void setTask_description(String Task_description) {
        this.Task_description = Task_description;
    }

    
    public int getTask_category_id() {
        return Task_category_id;
    }

    public void setTask_category_id(int Task_category_id) {
        this.Task_category_id = Task_category_id;
    }

    public String getCurrent_status() {
        return Current_status;
    }

    public void setCurrent_status(String Current_status) {
        this.Current_status = Current_status;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String Priority) {
        this.Priority = Priority;
    }

    public String getRaised_by() {
        return Raised_by;
    }

    public void setRaised_by(String Raised_by) {
        this.Raised_by = Raised_by;
    }

    public Date getRaise_date() {
        return Raise_date;
    }

    public void setRaise_date(Date Raise_date) {
        this.Raise_date = Raise_date;
    }

    public int getCompleted_by() {
        return Completed_by;
    }

    public void setCompleted_by(int Completed_by) {
        this.Completed_by = Completed_by;
    }

    public Date getComplete_date() {
        return Complete_date;
    }

    public void setComplete_date(Date Complete_date) {
        this.Complete_date = Complete_date;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public String getIs_active() {
        return Is_active;
    }

    public void setIs_active(String Is_active) {
        this.Is_active = Is_active;
    }

    public int getIs_deleted() {
        return Is_deleted;
    }

    public void setIs_deleted(int Is_deleted) {
        this.Is_deleted = Is_deleted;
    }

    public Date getAdd_date() {
        return Add_date;
    }

    public void setAdd_date(Date Add_date) {
        this.Add_date = Add_date;
    }

    public int getAdd_by() {
        return Add_by;
    }

    public void setAdd_by(int Add_by) {
        this.Add_by = Add_by;
    }

    public Date getLast_edit_date() {
        return Last_edit_date;
    }

    public void setLast_edit_date(Date Last_edit_date) {
        this.Last_edit_date = Last_edit_date;
    }

    public int getLast_edit_by() {
        return Last_edit_by;
    }

    public void setLast_edit_by(int Last_edit_by) {
        this.Last_edit_by = Last_edit_by;
    }

    /**
     * @return the Transactor_id
     */
    public long getTransactor_id() {
        return Transactor_id;
    }

    /**
     * @param Transactor_id the Transactor_id to set
     */
    public void setTransactor_id(long Transactor_id) {
        this.Transactor_id = Transactor_id;
    }

    /**
     * @return the Raise_date2
     */
    public Date getRaise_date2() {
        return Raise_date2;
    }

    /**
     * @param Raise_date2 the Raise_date2 to set
     */
    public void setRaise_date2(Date Raise_date2) {
        this.Raise_date2 = Raise_date2;
    }

    /**
     * @return the Task_category_name
     */
    public String getTask_category_name() {
        return Task_category_name;
    }

    /**
     * @param Task_category_name the Task_category_name to set
     */
    public void setTask_category_name(String Task_category_name) {
        this.Task_category_name = Task_category_name;
    }

}
