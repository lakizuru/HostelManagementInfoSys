/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.LoggedUser;

/**
 *
 * @author Semasinghe L.S. IT19051130
 */
public interface LoggedUserServices {
    public LoggedUser getLoggedUserInfo (String username);
    public void failedLogin(String username, int attempts);
}
