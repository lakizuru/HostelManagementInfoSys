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
import model.LoggedUser;
import util.Database;


public class LoggedUserServicesImpl implements LoggedUserServices {

    public LoggedUser getLoggedUserInfo(String username) {
        LoggedUser loggedUser = new LoggedUser();
        try {
                Class.forName(Database.dbDriver);
                Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
                Statement statement = connection.createStatement();

                String queryLoginDetails = "SELECT password, accountType, lastLogin, attempts FROM login WHERE username = '" + username + "'";

                ResultSet rsUsername = statement.executeQuery(queryLoginDetails);
                
                if(rsUsername.next()){
                    loggedUser.setPass(true);
                }

                loggedUser.setUsername(username);
                loggedUser.setPassword(rsUsername.getString("password"));
                loggedUser.setAccountType(rsUsername.getString("accountType"));
                loggedUser.setLastLogin(rsUsername.getString("lastLogin"));
                loggedUser.setAttempts(rsUsername.getInt("attempts"));
               
                //Closing DB Connection
                connection.close();

        }
        catch (ClassNotFoundException | SQLException dbError) {
                JOptionPane.showMessageDialog(null, dbError, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
        return loggedUser;
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
    
}
