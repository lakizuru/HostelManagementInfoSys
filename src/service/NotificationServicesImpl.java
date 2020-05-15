/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Notification;
import util.Database;
import util.DateTime;
import util.SessionData;


public class NotificationServicesImpl implements NotificationServices {
    public void newNotification(Notification notif) {
       try {

            //Openning DB connection
            Class.forName(Database.dbDriver);
            Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
            Statement statement = connection.createStatement();

            

            //SQL INSERT statements for new Notifications
            String queryNotif = "INSERT INTO notifications (notifUsername, notifTitle, date, description,senderUsername) VALUES (?,?,?,?,?)";

            //Prepared Statement Queries
            PreparedStatement psRequest = connection.prepareStatement(queryNotif);
            psRequest.setString(1, notif.getNotifUsername());
            psRequest.setString(2, notif.getNotifTitle());
            psRequest.setString(3, DateTime.sqlTime());
            psRequest.setString(4, notif.getNotifDescription());
            psRequest.setString(5, SessionData.getLoggedUser());
            

            //Executing Prepared Statements
            psRequest.execute();

            //Closing DB Connection
            connection.close();
        }
        catch (SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "You have entered existing notification title! \n" + e, "Invalid Inputs!", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
        catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Task Failed! \n" + e, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
       
       
    }

    @Override
    public void seenNotification(JTable table) {
        try{String C1;
        int i = table.getSelectedRow();
        
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        C1 = model.getValueAt(i, 0).toString();
        
        if(table.getSelectedRow() != -1) {
               
               model.removeRow(table.getSelectedRow());
               JOptionPane.showMessageDialog(null, "Notification seen successfully");
            }
        
        try{
            
           


            Statement st = Database.connectDB().createStatement();
            String query = "update notifications set seen='seen'"+" where notifTitle='"+C1+"';";
            st.executeUpdate(query);
            
         
         
        }catch(ArrayIndexOutOfBoundsException e1){
        
        }
        }catch(HeadlessException | ClassNotFoundException | SQLException e){JOptionPane.showMessageDialog(null, "Please Select a Row! \n" , "Please Select a Row.", JOptionPane.ERROR_MESSAGE);
                }
    }

    @Override
    public void deleteNotification(JTable table) {
        try{String C1;
        int i = table.getSelectedRow();
        
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        C1 = model.getValueAt(i, 0).toString();
        
        if(table.getSelectedRow() != -1) {
               
               model.removeRow(table.getSelectedRow());
               JOptionPane.showMessageDialog(null, "Notification deleted successfully");
            }
        
        try{
            
           


            Statement st = Database.connectDB().createStatement();
            String query = "delete from notifications where notifUsername='"+C1+"';";
            st.executeUpdate(query);
            
         
         
        }catch(ArrayIndexOutOfBoundsException e1){
        
        }
        }catch(HeadlessException | ClassNotFoundException | SQLException e){JOptionPane.showMessageDialog(null, "Please Select a Row! \n" , "Please Select a Row.", JOptionPane.ERROR_MESSAGE);
                }
    }
    
    
}
