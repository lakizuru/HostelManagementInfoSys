/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.User;

/**
 *
 * @author Semasinghe L.S. IT19051130
 */
public interface UserServices {
    public void newAccount(String username, String password, String accountType);
    
    public void newUser (User user);
}
