/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Notice;
import util.Database;


public class NoticeServicesImpl implements NoticeServices {
    
    public void newNotice(Notice notice) {
        try {
                //Openning DB connection
                Class.forName(Database.dbDriver);
                Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
                Statement statement = connection.createStatement();

                //SQL INSERT statements for new Guests
                String queryNotice = "INSERT INTO `oop`.`notice` (`dateTime`, `message`,`recipients`) VALUES (?,?,?)";

                //Prepared Statement Queries
                PreparedStatement psNotice = connection.prepareStatement(queryNotice);
                psNotice.setString(1, notice.getTimestamp());
                psNotice.setString(2, notice.getMessage());
                psNotice.setString(3, notice.getRecipients());

                //Executing Prepared Statements
                psNotice.execute();
                
                JOptionPane.showMessageDialog(null, "Notice sent successfully.", "SUCCESS!", JOptionPane.INFORMATION_MESSAGE);

                //Closing DB Connection
                connection.close();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Task Failed! \n" + e, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
        catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Task Failed! \n" + e, "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
    }
    
}
