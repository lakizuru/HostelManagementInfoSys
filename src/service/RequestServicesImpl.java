/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Request;
import util.Database;
import util.DateTime;
import util.SessionData;

/**
 *
 * @author Perera A.A.K.B. IT19080154
 */
public class RequestServicesImpl implements RequestServices{

    @Override
    public void newRequest(Request request) {
        try {

            //Openning DB connection
            Class.forName(Database.dbDriver);
            Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
            Statement statement = connection.createStatement();

            

            //SQL INSERT statements for new Requests
            String queryRequest = "INSERT INTO request (reqTitle, reqType, date, description, acceptedBy) VALUES (?,?,?,?,?)";

            //Prepared Statement Queries
            PreparedStatement psRequest = connection.prepareStatement(queryRequest);
            psRequest.setString(1, request.getReqTitle());
            psRequest.setString(2, request.getReqType());
            psRequest.setString(3, DateTime.sqlTime());
            psRequest.setString(4, request.getDescription());
            psRequest.setString(5, request.getAcceptedBy());

            //Executing Prepared Statements
            psRequest.execute();

            //Closing DB Connection
            connection.close();
        }
        catch (SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "You have entered existing request type! \n" + e, "Invalid Inputs!", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
        catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Task Failed! \n" + e, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
    }

    @Override
    public String takeDepartment() {
       
    String c = new String();
        try {
            Statement st = Database.connectDB().createStatement();
            ResultSet rs = st.executeQuery("select department from staff where username='"+SessionData.getLoggedUser()+"';");
            c = rs.getString(1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RequestServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RequestServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return c;
    
    }

    
}
