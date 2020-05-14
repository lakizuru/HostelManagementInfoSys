/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.awt.HeadlessException;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Request;
import util.Database;
import util.DateTime;
import util.SessionData;

/**
 *
 * @author Perera A.A.K.B. IT19080154
 */
public class RequestServicesImpl implements RequestServices{

    public String takeDepartment() {
       
    String c = new String();
        try {
            
            Statement st = Database.connectDB().createStatement();
            ResultSet rs = st.executeQuery("select department,username from staff where username='"+SessionData.getLoggedUser()+"';");
            while(rs.next()){
            c = rs.getString(1);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RequestServicesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return c;
    
    
    }
    
    public void acceptRequest(JTable table) {
        try{String C1;
        int i = table.getSelectedRow();
        
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        C1 = model.getValueAt(i, 0).toString();
        
        if(table.getSelectedRow() != -1) {
               
               model.removeRow(table.getSelectedRow());
               JOptionPane.showMessageDialog(null, "Accepted Request successfully");
            }
        
        try{
            
           


            Statement st = Database.connectDB().createStatement();
            String query = "update request set acceptedBy='"+SessionData.getLoggedUser()+"'"+" where reqTitle='"+C1+"';";
            st.executeUpdate(query);
            
         
         
        }catch(ArrayIndexOutOfBoundsException e1){
        
        }
        }catch(HeadlessException | ClassNotFoundException | SQLException e){JOptionPane.showMessageDialog(null, "Please Select a Row! \n" , "Please Select a Row.", JOptionPane.ERROR_MESSAGE);
                }
    }
    
    public void newRequest(Request request) {
        try {

            //Openning DB connection
            Class.forName(Database.dbDriver);
            Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
            Statement statement = connection.createStatement();

            

            //SQL INSERT statements for new Requests
            String queryRequest = "INSERT INTO request (reqTitle, reqType, date, description, acceptedBy,username) VALUES (?,?,?,?,?,?)";

            //Prepared Statement Queries
            PreparedStatement psRequest = connection.prepareStatement(queryRequest);
            psRequest.setString(1, request.getReqTitle());
            psRequest.setString(2, request.getReqType());
            psRequest.setString(3, DateTime.sqlTime());
            psRequest.setString(4, request.getDescription());
            psRequest.setString(5, request.getAcceptedBy());
            psRequest.setString(6, SessionData.getLoggedUser());

            //Executing Prepared Statements
            psRequest.execute();

            //Closing DB Connection
            connection.close();
        }
        catch (SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "You have entered existing request type! \n" + e, "Invalid Inputs!", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
        catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Task Failed! \n" + e, "Database Error", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
        }
    }

    @Override
    public void deleteRequest(JTable table) {
       try{String C1;
        int i = table.getSelectedRow();
        
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        C1 = model.getValueAt(i, 0).toString();
        
        if(table.getSelectedRow() != -1) {
               
               model.removeRow(table.getSelectedRow());
               JOptionPane.showMessageDialog(null, "Request deleted successfully");
            }
        
        try{
            
           


            Statement st = Database.connectDB().createStatement();
            String query = "delete from request where reqTitle='"+C1+"';";
            st.executeUpdate(query);
            
         
         
        }catch(ArrayIndexOutOfBoundsException e1){
        
        }
        }catch(HeadlessException | ClassNotFoundException | SQLException e){JOptionPane.showMessageDialog(null, "Please Select a Row! \n" , "Please Select a Row.", JOptionPane.ERROR_MESSAGE);
                }
    }
   
}
