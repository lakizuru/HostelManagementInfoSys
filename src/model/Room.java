/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import util.Database;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author lakis
 */
public class Room {
        private String roomNumber;
	float rental;
	int occupied = 0;
	int capasity;
	char block;
	
	public String assignRoom (Guest guest) {
		boolean adult = guest.isAge();
		boolean gender = guest.isGender();
		
		/*
		 * Adults
		 * 	Male - Block M
		 * 	Female Block W
		 * 
		 * Minors
		 * 	Male - Block B
		 * 	Female - Block G
		 */
		
		if (adult == true) {
			if (gender == true) {
				String roomNumber = findVacantRoom('M');
			}
			else {
				String roomNumber = findVacantRoom('W');
			}
		}
		else {
			if (gender == true) {
				String roomNumber = findVacantRoom('B');
			}
			else {
				String roomNumber = findVacantRoom('G');
			}
		}
		if (roomNumber == null) {
			
		}
		return roomNumber;
	}

	private String findVacantRoom(char block) {
		try {
			String roomNumber = null;
			Class.forName(Database.dbDriver);
			Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
			Statement statement = connection.createStatement();
			
			//finds a room in the specified block which is not full
			String queryVacantRooms = "SELECT roomNumber FROM room WHERE block = '" + block + "' AND occupied < capasity";
			
			ResultSet rsVacantRooms = statement.executeQuery(queryVacantRooms);
			
			if (rsVacantRooms.next()) {
				roomNumber = rsVacantRooms.getString("roomNumber");				
			}
			
			//Closing DB Connection
			connection.close();
						
		}
		catch (Exception error) {
			JOptionPane.showMessageDialog(null, error, "Database Error", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		return roomNumber;
        }
}
