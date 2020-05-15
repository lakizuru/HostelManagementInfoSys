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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.User;
import util.Database;
import util.DateTime;


public class UserServicesImpl implements UserServices {

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
                
                JOptionPane.showMessageDialog(null, "USER ACCOUNT CREATED!", "SUCCESS!", JOptionPane.INFORMATION_MESSAGE);
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
            String queryUser = "INSERT INTO user (username, name, nic, phone, address, gender, regDate) VALUES (?,?,?,?,?,?,?)";

            //Prepared Statement Queries
            PreparedStatement psUser = connection.prepareStatement(queryUser);
            psUser.setString(1, user.getUsername());
            psUser.setString(2, user.getName());
            psUser.setString(3, user.getNic());
            psUser.setString(4, user.getPhone());
            psUser.setString(5, user.getAddress());
            psUser.setBoolean(6, user.isGender());
            psUser.setString(7, DateTime.sqlTime());

            //Executing Prepared Statements
            psUser.execute();

            //Closing DB Connection
            connection.close();

        }

        catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Task Failed! \n" + e, "Database Error", JOptionPane.ERROR_MESSAGE);
                
                System.exit(-1);
        }
    }
    
    public void DeleteSelectedRow(JTable table) {
        int i = table.getSelectedRow();

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String username = model.getValueAt(i, 0).toString();
        
        try{
            Statement st = Database.connectDB().createStatement();        

            String queryDeleteUser = "delete from login where username = '" + username + "';";
            st.executeUpdate(queryDeleteUser);

        }
        catch(ArrayIndexOutOfBoundsException e1)
        {
            JOptionPane.showMessageDialog(null, "Please Select a Row. \n" , "Please Select a Row!", JOptionPane.ERROR_MESSAGE);
        
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Please Select a Row! \n" , "Please Select a Row.", JOptionPane.ERROR_MESSAGE);        
        }
}
        
    
}
