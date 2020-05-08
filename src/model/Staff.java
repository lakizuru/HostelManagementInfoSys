/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import util.Database;
import javax.swing.JOptionPane;

/**
 *
 * @author lakis
 */
public class Staff extends User {
    private double salary;
    private String bank, accountNo;
    private String dept; //department

    public Staff(String username, String name, String nic, String phone, String address, boolean gender,
                    int salary, String bank, String accountNo, String dept) {
            super(username, name, nic, phone, address, gender);
            this.salary = salary;
            this.bank = bank;
            this.accountNo = accountNo;
            this.dept = dept;
    }

    public double getSalary() {
            return salary;
    }

    public void setSalary(double salary) {
            this.salary = salary;
    }

    public String getBank() {
            return bank;
    }

    public void setBank(String bank) {
            this.bank = bank;
    }

    public String getAccountNo() {
            return accountNo;
    }

    public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
    }

    public String getDept() {
            return dept;
    }

    public void setDept(String dept) {
            this.dept = dept;
    }

    public static void newStaff (Staff staff) {
            try {
            //Openning DB connection
            Class.forName(Database.dbDriver);
            Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
            Statement statement = connection.createStatement();

            User.newUser(staff);

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
            catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Task Failed! \n" + e, "Database Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(-1);
            }
    }

}
