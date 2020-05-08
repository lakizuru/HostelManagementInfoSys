/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.*;

/**
 *
 * @author lakis
 */
public class Database {
    //Database access info
    public static final String dbDriver = "com.mysql.jdbc.Driver";
    public static final String dbURL = "jdbc:mysql://localhost/oop";
    public static final String dbUsername = "lakisuru";
    public static final String dbPassword = "Hannah<3";

    private static Connection dbConnection;

    public static Connection connectDB() throws ClassNotFoundException, SQLException {
            if (dbConnection == null || dbConnection.isClosed()) {

                    Class.forName(dbDriver);
                    dbConnection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            }
            return dbConnection;
    }
}
