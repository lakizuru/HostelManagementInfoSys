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
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Staff;
import model.User;
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
            String queryStaff = "INSERT INTO staff (salary, bank, accNumber, department) VALUES (?,?,?,?)";

            //Prepared Statement Queries
            PreparedStatement psStaff = connection.prepareStatement(queryStaff);
            psStaff.setDouble(1, staff.getSalary());
            psStaff.setString(2, staff.getBank());
            psStaff.setString(3, staff.getAccountNo());
            psStaff.setString(4, staff.getDept());

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
}
