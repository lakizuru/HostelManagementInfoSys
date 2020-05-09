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

    public Room(String roomNumber, float rental, int capasity) {
        this.roomNumber = roomNumber;
        this.rental = rental;
        this.capasity = capasity;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public float getRental() {
        return rental;
    }

    public void setRental(float rental) {
        this.rental = rental;
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public int getCapasity() {
        return capasity;
    }

    public void setCapasity(int capasity) {
        this.capasity = capasity;
    }

        
	
	public static String assignRoom (boolean gender, boolean age) {
			
		/*
		 * Adults
		 * 	Male - Block M
		 * 	Female Block W
		 * 
		 * Minors
		 * 	Male - Block B
		 * 	Female - Block G
		 */
		
		if (age == true) {
			if (gender == true) {
				return findVacantRoom('M');
			}
			else {
				return findVacantRoom('W');
			}
		}
		else {
			if (gender == true) {
				return findVacantRoom('B');
			}
			else {
				return findVacantRoom('G');
			}
		}
	}

	private static String findVacantRoom(char block) {
            String roomNumber = null;
		try {
			Class.forName(Database.dbDriver);
			Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
			Statement statement = connection.createStatement();
			
			//finds a room in the specified block which is not full
			String queryVacantRooms = "SELECT roomNumber FROM room WHERE roomNumber = '" + block + "???' AND occupied < capasity";
			
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
        
        /*
        public static String newRoomNo (char block){
            try {
			String roomNumber = null;
			Class.forName(Database.dbDriver);
			Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
			Statement statement = connection.createStatement();
			
			//finds the lastly added room of specific block
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
            
        }*/
        
        public void AddRoom(){
            try {
			Class.forName(Database.dbDriver);
			Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
			//Statement statement = connection.createStatement();
			
			//SQL INSERT statements for new Guests
                        String queryRoom = "INSERT INTO room (roomNumber, rental, capasity) VALUES (?,?,?)";

                        //Prepared Statement Queries
                        PreparedStatement psRoom = connection.prepareStatement(queryRoom);
                        psRoom.setString(1, roomNumber);
                        psRoom.setFloat(2, rental);
                        psRoom.setInt(3, capasity);

                        //Executing Prepared Statements
                        psRoom.execute();
			
			//Closing DB Connection
			connection.close();
						
		}
		catch (Exception error) {
			JOptionPane.showMessageDialog(null, error, "Database Error", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
        }
}
