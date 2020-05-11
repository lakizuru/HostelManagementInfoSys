package model;

/**
 *
 * @author Semasinghe L.S. IT19051130
 */
public class Room {
        private String roomNumber;
	float rental;
	int occupied;
	int capasity;

    public Room() {
    }

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
        
        
}
