/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Perera A.A.K.B. IT19080154
 */
public class Notification {
    
    private String notifUsername;
    private String notifTitle;
    private String notifDate;
    private String notifDescription;
    private String senderUsername;

    public Notification() {
    }
    
    

    public Notification(String notifUsername, String notifTitle, String notifDate, String notifDescription) {
        this.notifUsername = notifUsername;
        this.notifTitle = notifTitle;
        this.notifDate = notifDate;
        this.notifDescription = notifDescription;
    }

    public String getNotifUsername() {
        return notifUsername;
    }

    public void setNotifUsername(String notifUsername) {
        this.notifUsername = notifUsername;
    }

    public String getNotifTitle() {
        return notifTitle;
    }

    public void setNotifTitle(String notifTitle) {
        this.notifTitle = notifTitle;
    }

    public String getNotifDate() {
        return notifDate;
    }

    public void setNotifDate(String notifDate) {
        this.notifDate = notifDate;
    }

    public String getNotifDescription() {
        return notifDescription;
    }

    public void setNotifDescription(String notifDescription) {
        this.notifDescription = notifDescription;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }
    
    
    
    
    
}
