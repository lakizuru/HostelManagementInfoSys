/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Staff;

/**
 *
 * @author Semasinghe L.S. IT19051130
 */
public interface StaffServices {
    public void newStaff (Staff staff);
    public int getNoOfStaff();
    //public ArrayList<Staff> getStaff();
}
