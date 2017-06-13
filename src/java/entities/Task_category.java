/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author philp
 */
@ManagedBean
@SessionScoped
public class Task_category {
     private static final long serialVersionUID = 1L;
     
     private int Task_category_id;
     private String Task_category_name;

    public int getTask_category_id() {
        return Task_category_id;
    }

    public void setTask_category_id(int Task_category_id) {
        this.Task_category_id = Task_category_id;
    }
     
     public String getTask_category_name() {
        return Task_category_name;
    }

    public void setTask_category_name(String Task_category_name) {
        this.Task_category_name = Task_category_name;
    }
     
     
}
