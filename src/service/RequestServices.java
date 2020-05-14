/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.swing.JTable;
import model.Request;

/**
 *
 * @author Perera A.A.K.B. Perera
 */
public interface RequestServices {
    public String takeDepartment();
    public void acceptRequest(JTable table);
    public void newRequest(Request request);
    public void deleteRequest(JTable table);
 
}
