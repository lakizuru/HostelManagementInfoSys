/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author lakis
 */
public class SessionData {
    private static String loggedUser;

    public static String getLoggedUser() {
            return loggedUser;
    }

    public static void setLoggedUser(String loggedUser) {
            SessionData.loggedUser = loggedUser;
    }
}
