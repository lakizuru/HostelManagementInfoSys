package model;
/**
 *
 * @author Semasinghe L.S. IT19051130
 */
public class Guest extends User {
    private boolean availability;
    private String room;
    private boolean age; //adult or minor

    public Guest(String username, String name, String nic, String phone, String address, boolean gender,
                    boolean availability, String room, boolean age) {
        super(username, name, nic, phone, address, gender);
        this.availability = availability;
        this.room = room;
        this.age = age;
    }

    public Guest() {
    }

    public boolean isAge() {
            return age;
    }

    public void setAge(boolean age) {
            this.age = age;
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
}
