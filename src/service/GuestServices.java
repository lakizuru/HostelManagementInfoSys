/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import javax.swing.JTable;
import model.Guest;

/**
 *
 * @author Semasinghe L.S. IT19051130
 */
public interface GuestServices { 
   public void newGuest (Guest guest);
   public int getNoOfRegGuests();
   public int getNoOfAvailGuests();
   public void checkInOut(JTable table);
   public void checkInOut(String username);
   public void DeleteSelectedRow(JTable table);
}
