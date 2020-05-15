package util;

import java.util.regex.*;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Semasinghe L.S. IT19051130
 */
public class Validate {
	
	//checks the validity of the new usernames
	public static boolean isUsernameValid(String username) {
		boolean valid = false;
		
		//checks whether username has decent amount of characters
				if (username.length() >= 4 && username.length() <= 8) {
					//checks whether username has allowed characters
					Pattern p = Pattern.compile("[^A-Za-z0-9_.]");
					Matcher m = p.matcher(username);
					if(!(m.find())){
						try {
							Class.forName(Database.dbDriver);
							Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
							Statement statement = connection.createStatement();
							
							String query = "SELECT username FROM login WHERE username = '" + username + "'";
							
							ResultSet resultSet = statement.executeQuery(query);
							
							// check whether similar username exists
							if (resultSet.next()) {
								valid = false;
							}
							else
							{
								valid = true;
							}
							
							//Closing DB Connection
							connection.close();
							
						}
						catch (Exception dbError) {
							JOptionPane.showMessageDialog(null, dbError, "Database Error", JOptionPane.ERROR_MESSAGE);
							System.exit(-1);
						}
						
					}
				}
				return valid;		
	}
	
	//checks the validity of the passwords
	public static boolean isPasswordValid (String password1, String password2) {
		boolean valid = false;
		//checks whether 2 passwords are similar
		if (password1.equals(password2)) {
			//checks whether password has decent amount of characters
			if (password1.length() >= 8 && password1.length() <= 16) {
					valid = true;
				}
			}
		
		return valid;
	}
	
	//checks for validity of the names
	public static boolean isNameValid (String name) {
		
		//checks whether name has anything other than letters
		Pattern p = Pattern.compile("[^A-Za-z ]");
		Matcher m = p.matcher(name);
		boolean valid = !(m.find());

		return valid;
	}
	
	//checks for validity of the phone
	public static boolean isPhoneValid(String phone) {
		boolean valid = false;
		//checks for phone number length
		if (phone.length() == 10) {
			//checks whether phone has anything other than numbers
			Pattern p = Pattern.compile("[^0-9]");
			Matcher m = p.matcher(phone);
			valid = !(m.find());
		}
		return valid;
		
	}
	
	//checks validity of nic number
	public static boolean isNICValid(String NIC) {
		boolean valid = false;
		
		//checks for the number of characters
		if (NIC.length() == 10) {
			if (NIC.toCharArray()[9] == 'V' || NIC.toCharArray()[9] == 'v') {

				//checks whether name has anything other than digits and V,v
				Pattern p = Pattern.compile("[^0-9]");
				Matcher m = p.matcher(NIC.substring(0, 8));
                                
                                if (!(m.find())){
                                    valid = Validate.nicDuplicated(NIC);
                                }
			}
		}
		else if(NIC.length() == 12) {
				//checks whether name has anything other than digits
				Pattern p = Pattern.compile("[^0-9]");
				Matcher m = p.matcher(NIC);
				
                                if (!(m.find())){
                                    valid = Validate.nicDuplicated(NIC);
                                }
			
		}
			return valid;
	}
	
	//checks validity of room number
	public static boolean isRoomNoValid(String roomNo) {
		boolean valid = false;
		
		//checks number of characters
		if (roomNo.length() == 4) {
			if (roomNo.toCharArray()[0] == 'W' || roomNo.toCharArray()[0] == 'G' || roomNo.toCharArray()[0] == 'M' || roomNo.toCharArray()[0] == 'B') {
				//checks whether roomNo characters 2,3,4 hav anything other than digits
				Pattern p = Pattern.compile("[^0-9]");
				Matcher m = p.matcher(roomNo.substring(1));
				valid = !(m.find());
			}
		}
		return valid;
		
	}
	
	// checks department
	public static boolean isDeptValid(String dept) {
		boolean valid = false;
		
		if (dept.contentEquals("Kitchen") || dept.contentEquals("Administration") || dept.contentEquals("Laundry") ||dept.contentEquals("Cleaning") ||dept.contentEquals("Technical")) {
			valid = true;
		}
		return valid;
	}
	
	// checks money amounts and numbers
	public static boolean isMoneyValid (String amount) {
		
		Pattern p = Pattern.compile("[^0-9]");
		Matcher m = p.matcher(amount);
		boolean valid = !(m.find());
		return valid;
	}
        
        private static boolean nicDuplicated(String nic){
            boolean valid = false;
            try {
                    Class.forName(Database.dbDriver);
                    Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
                    Statement statement = connection.createStatement();

                    String query = "SELECT * FROM user WHERE nic = '" + nic + "'";

                    ResultSet resultSet = statement.executeQuery(query);

                    // check whether similar username exists
                    if (resultSet.next()) {
                            valid = false;
                    }
                    else
                    {
                            valid = true;
                    }

                    //Closing DB Connection
                    connection.close();

            }
            catch (ClassNotFoundException | SQLException dbError) {
                    JOptionPane.showMessageDialog(null, dbError, "Database Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(-1);
            }
            return valid;
        }

}

