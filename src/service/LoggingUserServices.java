/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Guest;
import model.Staff;
import model.LoggingUser;

/**
 *
 * @author Semasinghe L.S. IT19051130
 */
public interface LoggingUserServices {
    public LoggingUser getLoggingUserInfo(String username);
    public void failedLogin(String username, int attempts);
    public Staff getLoggedStaffInfo(String username);
    public Guest getLoggedGuestInfo(String username);
    public void updateLastLogin(String username);
}
