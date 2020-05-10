package util;

/**
 *
 * @author Semasinghe L.S. IT19051130
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
