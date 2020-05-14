package model;

import java.sql.*;
import javax.swing.JOptionPane;
import util.Database;

/**
 *
 * @author Semasinghe L.S. IT19051130
 */
public class User {
    private String username; 
    private String name;
    private String nic; // National ID card Number
    private String phone;
    private String address;
    private boolean gender; // male - 1, female - 0
    
    public User(String username, String name){
        this.username = username;
        this.name = name;
    }
    
    public User(){
        
    }

    public User(String username, String name, String nic, String phone, String address, boolean gender) {
        super();
        this.username = username;
        this.name = name;
        this.nic = nic;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }

    public String getUsername() {
            return username;
    }

    public void setUsername(String username) {
            this.username = username;
    }

    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }

    public String getNic() {
            return nic;
    }

    public void setNic(String nic) {
            this.nic = nic;
    }

    public String getPhone() {
            return phone;
    }

    public void setPhone(String phone) {
            this.phone = phone;
    }

    public String getAddress() {
            return address;
    }

    public void setAddress(String address) {
            this.address = address;
    }

    public boolean isGender() {
            return gender;
    }

    public void setGender(boolean gender) {
            this.gender = gender;
    }

}
