package util;

import java.sql.*;

/**
 *
 * @author Semasinghe L.S. IT19051130
 */
public class Database {
    //Database access info
    public static final String dbDriver = "com.mysql.cj.jdbc.Driver";
    public static final String dbURL = "jdbc:mysql://localhost/oop";
    public static final String dbUsername = "root";
    public static final String dbPassword = "root123";

    private static Connection dbConnection;

    public static Connection connectDB() throws ClassNotFoundException, SQLException {
            if (dbConnection == null || dbConnection.isClosed()) {

                    Class.forName(dbDriver);
                    dbConnection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            }
            return dbConnection;
    }
}
