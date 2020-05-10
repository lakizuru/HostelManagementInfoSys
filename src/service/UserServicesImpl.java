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
import model.User;
import util.Database;


public class UserServicesImpl implements UserServices {

    @Override
        public void newAccount(String username, String password, String accountType) {
        try {
                //Openning DB connection
                Class.forName(Database.dbDriver);
            try (Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword)) {
                Statement statement = connection.createStatement();
                //SQL Insert statement for new login
                String query = "INSERT INTO login (username, password, accountType) VALUES (?,?,?)";
                //Prepared Statement queries			
                PreparedStatement psLogin = connection.prepareStatement(query);
                psLogin.setString(1, username);
                psLogin.setString(2, password);
                psLogin.setString(3, accountType);
                //Execute prepared statements
                psLogin.execute();
                String msg = "Username: " + username + "\nPassword: " + password;
                JOptionPane.showMessageDialog(null, "USER ACCOUNT CREATED!\n\n" + msg, "SUCCESS!", JOptionPane.INFORMATION_MESSAGE);
                //Closing DB Connection
            }
        }
        catch (SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "You have entered existing user's information \n" + e, "Invalid Inputs!", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
        catch (HeadlessException | ClassNotFoundException | SQLException e)
        {
                JOptionPane.showMessageDialog(null, "Task Failed! \n" + e, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
}
        public void newUser (User user) {
        try {
            //Openning DB connection
            Class.forName(Database.dbDriver);
            Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
            Statement statement = connection.createStatement();

            //SQL INSERT statements for new User
            String queryUser = "INSERT INTO user (username, name, nic, phone, address, gender) VALUES (?,?,?,?,?,?)";

            //Prepared Statement Queries
            PreparedStatement psUser = connection.prepareStatement(queryUser);
            psUser.setString(1, user.getUsername());
            psUser.setString(2, user.getName());
            psUser.setString(3, user.getNic());
            psUser.setString(4, user.getPhone());
            psUser.setString(5, user.getAddress());
            psUser.setBoolean(6, user.isGender());

            //Executing Prepared Statements
            psUser.execute();

            //Closing DB Connection
            connection.close();

        }

        catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Task Failed! \n" + e, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
    }
    
}
