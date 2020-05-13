/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Notification;
import util.Database;
import util.DateTime;
import util.SessionData;

/**
 *
 * @author Perera A.A.K.B. IT19080154
 */
public class NotificationServicesImpl implements NotificationServices{

    @Override
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
        catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Task Failed! \n" + e, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
       
       
    }
    
}
