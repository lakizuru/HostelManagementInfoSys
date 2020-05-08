/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import javax.swing.JOptionPane;
import util.Database;

/**
 *
 * @author lakis
 */
public class User {
    private String username; 
    private String name;
    private String nic; // National ID card Number
    private String phone;
    private String address;
    private boolean gender; // male - 1, female - 0

    public User(String username, String name, String nic, String phone, String address, boolean gender) {
        super();
        this.username = username;
        this.name = name;
        this.nic = nic;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }

    public String getUsername() {
            return username;
    }

    public void setUsername(String username) {
            this.username = username;
    }

    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }

    public String getNic() {
            return nic;
    }

    public void setNic(String nic) {
            this.nic = nic;
    }

    public String getPhone() {
            return phone;
    }

    public void setPhone(String phone) {
            this.phone = phone;
    }

    public String getAddress() {
            return address;
    }

    public void setAddress(String address) {
            this.address = address;
    }

    public boolean isGender() {
            return gender;
    }

    public void setGender(boolean gender) {
            this.gender = gender;
    }

    public static void newAccount(String username, String password, String accountType) {
        try {
                //Openning DB connection
                Class.forName(Database.dbDriver);
                Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
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
                connection.close();
        }
        catch (SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "You have entered existing user's information \n" + e, "Invalid Inputs!", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
        catch (Exception e)
        {
                JOptionPane.showMessageDialog(null, "Task Failed! \n" + e, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
}

//Generate Random Password
//this will not be used
        private static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";

        public static final String genPassword() {
                int noOfChars = 8; // No. of characters in the password
                StringBuilder tempPass = new StringBuilder();

                for (; noOfChars != 0; noOfChars--) {
                        int charac = (int)(Math.random() * chars.length());
                        tempPass.append(chars.charAt(charac));
                }
                return tempPass.toString();
        }

public static void newUser (User user) {
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
