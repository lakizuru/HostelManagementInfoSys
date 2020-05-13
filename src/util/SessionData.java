package util;

/**
 *
 * @author Semasinghe L.S. IT19051130
 */
public class SessionData {
    private static String loggedUser;
    private static String loggedAccountType;
    private static String loggedName;

    public static String getLoggedAccountType() {
        return loggedAccountType;
    }

    public static void setLoggedAccountType(String loggedAccountType) {
        SessionData.loggedAccountType = loggedAccountType;
    }

    public static String getLoggedUser() {
            return loggedUser;
    }

    public static void setLoggedUser(String loggedUser) {
            SessionData.loggedUser = loggedUser;
    }
}