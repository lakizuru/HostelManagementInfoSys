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
import model.Guest;
import util.Database;





public class GuestServicesImpl implements GuestServices {
    public void newGuest (Guest guest) {
		try {
			
			//Openning DB connection
			Class.forName(Database.dbDriver);
			Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
			
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
    
    public int getNoOfRegGuests(){
        int count = 0;
        try {
                Class.forName(Database.dbDriver);
                Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
                Statement statement = connection.createStatement();

                String queryGuestCount = "SELECT COUNT(*) FROM guest";

                ResultSet rsGuestCount = statement.executeQuery(queryGuestCount);
                rsGuestCount.next();
                
                count = rsGuestCount.getInt(1);
               
                //Closing DB Connection
                connection.close();

        }
        catch (ClassNotFoundException | SQLException dbError) {
                JOptionPane.showMessageDialog(null, dbError, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
        return count;
    }
    
    public int getNoOfAvailGuests(){
        int count = 0;
        try {
                Class.forName(Database.dbDriver);
                Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
                Statement statement = connection.createStatement();

                String queryGuestCount = "SELECT COUNT(*) FROM guest WHERE availability = 1";

                ResultSet rsGuestCount = statement.executeQuery(queryGuestCount);
                rsGuestCount.next();
                
                count = rsGuestCount.getInt(1);
               
                //Closing DB Connection
                connection.close();

        }
        catch (ClassNotFoundException | SQLException dbError) {
                JOptionPane.showMessageDialog(null, dbError, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
        return count;
    }
    
    public void checkInOut(JTable table){
        
        int i = table.getSelectedRow();
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String username = model.getValueAt(i, 0).toString();
        
        try {
                Class.forName(Database.dbDriver);
                Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
                Statement statement = connection.createStatement();

                String queryGuestAvail = "SELECT availability FROM guest WHERE username = '" + username + "';";

                ResultSet rsGuestAvail = statement.executeQuery(queryGuestAvail);
                rsGuestAvail.next();
                
                if(rsGuestAvail.getInt(1) == 1){
                    queryGuestAvail = "UPDATE `oop`.`guest` SET `availability` = 0 WHERE `username` = '" + username + "';";
                }
                else if (rsGuestAvail.getInt(1) == 0){
                    queryGuestAvail = "UPDATE `oop`.`guest` SET `availability` = 1 WHERE `username` = '" + username + "';";
                }
                
                statement.execute(queryGuestAvail);
               
                //Closing DB Connection
                connection.close();

        }
        catch (ClassNotFoundException | SQLException dbError) {
                JOptionPane.showMessageDialog(null, dbError, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
    }
    
    public void checkInOut(String username){
        
        try {
                Class.forName(Database.dbDriver);
                Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
                Statement statement = connection.createStatement();

                String queryGuestAvail = "SELECT availability FROM guest WHERE username = '" + username + "';";

                ResultSet rsGuestAvail = statement.executeQuery(queryGuestAvail);
                
                if(rsGuestAvail.next()){
                    if(rsGuestAvail.getInt(1) == 1){
                    queryGuestAvail = "UPDATE `oop`.`guest` SET `availability` = 0 WHERE `username` = '" + username + "';";
                }
                else if (rsGuestAvail.getInt(1) == 0){
                    queryGuestAvail = "UPDATE `oop`.`guest` SET `availability` = 1 WHERE `username` = '" + username + "';";
                }
                
                statement.executeUpdate(queryGuestAvail);
                JOptionPane.showMessageDialog(null, "Successfully changed the Availability status", "Success!", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Username you have entered is not found in the database", "Invalid Username", JOptionPane.ERROR_MESSAGE);
                }
               
                //Closing DB Connection
                connection.close();

        }
        catch (ClassNotFoundException | SQLException dbError) {
                JOptionPane.showMessageDialog(null, dbError, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
    }
    
    public void DeleteSelectedRow(JTable table)
    {
        int i = table.getSelectedRow();

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String username = model.getValueAt(i, 0).toString();
        
        try{
            Statement st = Database.connectDB().createStatement();   
        
            String queryUser = "SELECT roomNumber FROM guest WHERE username = '" + username + "';";

            ResultSet rs = st.executeQuery(queryUser);
            
            if(rs.next())
            {
                String roomNo;
                roomNo = rs.getString("roomNumber");
                
                String queryOccupied = "SELECT occupied FROM room WHERE roomNumber = '" + roomNo + "';";
                rs = st.executeQuery(queryOccupied);
                
                int occupied;
                if (rs.next()){
                    occupied = rs.getInt("occupied");
                    queryOccupied = "UPDATE `oop`.`room` SET `occupied` = '" + (occupied-1) + "' WHERE `roomNumber` = '" + roomNo + "';";
                    st.executeUpdate(queryOccupied);
                    
                }
                        
            }
    }
        catch(ArrayIndexOutOfBoundsException e1)
        {
            JOptionPane.showMessageDialog(null, "Please Select a Row. \n" , "Please Select a Row!", JOptionPane.ERROR_MESSAGE);
        
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Please Select a Row! \n" , "Please Select a Row.", JOptionPane.ERROR_MESSAGE);        
        }
        UserServices userServices = new UserServicesImpl();
        userServices.DeleteSelectedRow(table);
    }
}
