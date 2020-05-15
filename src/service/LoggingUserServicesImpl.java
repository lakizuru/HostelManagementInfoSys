/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Guest;
import model.Staff;
import model.LoggingUser;
import util.Database;
import util.DateTime;


public class LoggingUserServicesImpl implements LoggingUserServices {

    public LoggingUser getLoggingUserInfo(String username) {
        LoggingUser loggingUser = new LoggingUser();
        try {
                Class.forName(Database.dbDriver);
                Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
                Statement statement = connection.createStatement();

                String queryLoginDetails = "SELECT password, accountType, lastLogin, attempts FROM login WHERE username = '" + username + "'";

                ResultSet rsUsername = statement.executeQuery(queryLoginDetails);
                
                if(rsUsername.next()){
                    loggingUser.setPass(true);
                    loggingUser.setUsername(username);
                    loggingUser.setPassword(rsUsername.getString("password"));
                    loggingUser.setAccountType(rsUsername.getString("accountType"));
                    loggingUser.setLastLogin(rsUsername.getString("lastLogin"));
                    loggingUser.setAttempts(rsUsername.getInt("attempts"));
                }

                
               
                //Closing DB Connection
                connection.close();

        }
        catch (ClassNotFoundException | SQLException dbError) {
                JOptionPane.showMessageDialog(null, dbError, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
        return loggingUser;
    }

    @Override
    public void failedLogin(String username, int attempts) {
        try {
                Class.forName(Database.dbDriver);
                Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
                Statement statement = connection.createStatement();

                String queryAttempts = "UPDATE `oop`.`login` SET `attempts` = " + attempts + " WHERE `username` = '" + username + "'";
                statement.execute(queryAttempts);
               
                //Closing DB Connection
                connection.close();

        }
        catch (ClassNotFoundException | SQLException dbError) {
                JOptionPane.showMessageDialog(null, dbError, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
    }
    public Staff getLoggedStaffInfo(String username) {
        Staff loggedStaff = new Staff();
        try {
                Class.forName(Database.dbDriver);
                Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
                Statement statement = connection.createStatement();

                String queryLoginDetails = "SELECT u.name, s.department FROM user as u, staff as s WHERE u.username = '" + username + "' AND u.username = s.username";

                ResultSet rsUsername = statement.executeQuery(queryLoginDetails);
                rsUsername.next();
                
                loggedStaff.setUsername(username);
                loggedStaff.setName(rsUsername.getString("name"));
                loggedStaff.setDept(rsUsername.getString("department"));
               
                //Closing DB Connection
                connection.close();

        }
        catch (ClassNotFoundException | SQLException dbError) {
                JOptionPane.showMessageDialog(null, dbError, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
        return loggedStaff;
    }
    
    public Guest getLoggedGuestInfo(String username) {
        Guest loggedGuest = new Guest();
        try {
                Class.forName(Database.dbDriver);
                Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
                Statement statement = connection.createStatement();

                String queryLoginDetails = "SELECT u.name, u.gender, g.age FROM user as u, guest as g WHERE u.username = '" + username + "' AND u.username = g.username";

                ResultSet rsUsername = statement.executeQuery(queryLoginDetails);
                rsUsername.next();
                
                loggedGuest.setUsername(username);
                loggedGuest.setName(rsUsername.getString("name"));
                loggedGuest.setAge(rsUsername.getBoolean("age"));
                loggedGuest.setGender(rsUsername.getBoolean("gender"));
               
                //Closing DB Connection
                connection.close();

        }
        catch (ClassNotFoundException | SQLException dbError) {
                JOptionPane.showMessageDialog(null, dbError, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
        return loggedGuest;
    }
    
    public void updateLastLogin(String username){
        try {
                Class.forName(Database.dbDriver);
                Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
                Statement statement = connection.createStatement();

                String queryAttempts = "UPDATE `oop`.`login` SET `lastLogin` = '" + DateTime.sqlTime() + "', `attempts` = 0 WHERE `username` = '" + username + "'";
                statement.execute(queryAttempts);
               
                //Closing DB Connection
                connection.close();

        }
        catch (ClassNotFoundException | SQLException dbError) {
                JOptionPane.showMessageDialog(null, dbError, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
    }
}
