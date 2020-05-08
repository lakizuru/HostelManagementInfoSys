/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;
import java.sql.*;
import util.Database;

/**
 *
 * @author lakis
 */
public class Guest extends User {
    private boolean availability;
    private String room;
    private boolean age; //adult or minor
    private String emName; // emergency contact name
    private String emPhone; // emergency contact phone

    public Guest(String username, String name, String nic, String phone, String address, boolean gender,
                    boolean availability, String room, boolean age, String emName, String emPhone) {
        super(username, name, nic, phone, address, gender);
        this.availability = availability;
        this.room = room;
        this.age = age;
        this.emName = emName;
        this.emPhone = emPhone;
    }

    public boolean isAge() {
            return age;
    }

    public void setAge(boolean age) {
            this.age = age;
    }

    public String getEmName() {
            return emName;
    }

    public void setEmName(String emName) {
            this.emName = emName;
    }

    public String getEmPhone() {
            return emPhone;
    }

    public void setEmPhone(String emPhone) {
            this.emPhone = emPhone;
    }

    public boolean isAvailability() {
            return availability;
    }

    public void setAvailability(boolean availability) {
            this.availability = availability;
    }

    public String getRoom() {
            return room;
    }

    public void setRoom(String room) {
            this.room = room;
    }

    public static void newGuest (Guest guest) {
        try {

            //Openning DB connection
            Class.forName(Database.dbDriver);
            Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
            Statement statement = connection.createStatement();

            User.newUser(guest);

            //SQL INSERT statements for new Guests
            String queryGuest = "INSERT INTO guest (username, availability, room) VALUES (?,?,?)";

            //Prepared Statement Queries
            PreparedStatement psGuest = connection.prepareStatement(queryGuest);
            psGuest.setString(1, guest.getUsername());
            psGuest.setBoolean(2, guest.isAvailability());
            psGuest.setString(3, guest.getRoom());

            //Executing Prepared Statements
            psGuest.execute();

            //Closing DB Connection
            connection.close();
        }
        catch (SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "You have entered existing user's information \n" + e, "Invalid Inputs!", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
        catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Task Failed! \n" + e, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
    }
}
