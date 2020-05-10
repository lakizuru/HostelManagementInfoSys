/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.swing.JOptionPane;
import model.Guest;
import util.Database;
import java.sql.*;
import model.User;


public class GuestServicesImpl implements GuestServices {
    public void newGuest (Guest guest) {
		try {
			
			//Openning DB connection
			Class.forName(Database.dbDriver);
			Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
			Statement statement = connection.createStatement();
			
			UserServices userService = new UserServicesImpl();
                        userService.newUser(guest);
			
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
