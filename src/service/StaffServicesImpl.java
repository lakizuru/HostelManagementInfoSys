/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import model.Staff;
import util.Database;



public class StaffServicesImpl implements StaffServices {
    
    public void newStaff (Staff staff) {
            try {
            //Openning DB connection
            Class.forName(Database.dbDriver);
            Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
            Statement statement = connection.createStatement();

            UserServices userService = new UserServicesImpl();
            userService.newUser(staff);

            //SQL INSERT statements for new Staff
            String queryStaff = "INSERT INTO staff (username, salary, department) VALUES (?,?,?)";

            //Prepared Statement Queries
            PreparedStatement psStaff = connection.prepareStatement(queryStaff);
            psStaff.setString(1, staff.getUsername());
            psStaff.setDouble(2, staff.getSalary());
            psStaff.setString(3, staff.getDept());

            //Executing Prepared Statements
            psStaff.execute();

            //Closing DB Connection
            connection.close();
            }
            catch (ClassNotFoundException | SQLException e) {
                    JOptionPane.showMessageDialog(null, "Task Failed! \n" + e, "Database Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(-1);
            }
    }
    public int getNoOfStaff(){
        int count = 0;
        try {
                Class.forName(Database.dbDriver);
                Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
                Statement statement = connection.createStatement();

                String queryStaffCount = "SELECT COUNT(*) FROM staff";

                ResultSet rsStaffCount = statement.executeQuery(queryStaffCount);
                rsStaffCount.next();
                
                count = rsStaffCount.getInt(1);
               
                //Closing DB Connection
                connection.close();

        }
        catch (ClassNotFoundException | SQLException dbError) {
                JOptionPane.showMessageDialog(null, dbError, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
        return count;
    }
}
    
    

/*    
    public ArrayList<Staff> getStaff(){
                ArrayList<Staff> staffList = new ArrayList<>();
        try {
            Statement statement =Database.connectDB().createStatement();
            ResultSet rsStaff = statement.executeQuery("SELECT * FROM user as u, staff as s WHERE u.username = s.username");

            Staff staff;

            while(rsStaff.next()){
                staff = new Staff(rsStaff.getString("username"), rsStaff.getString("name"), rsStaff.getString("nic"), rsStaff.getString("phone"), 
                        rsStaff.getString("address"), rsStaff.getBoolean("gender"), rsStaff.getInt("salary"), rsStaff.getString("bank"),
                        rsStaff.getString("accNumber"), rsStaff.getString("department"));
                staffList.add(staff);
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Task Failed! \n" + e, "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
        return staffList;
    } */


