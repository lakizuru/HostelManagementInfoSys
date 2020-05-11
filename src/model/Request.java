package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import util.Database;
import util.DateTime;

/**
 *
 * @author Perera A.A.K.B. IT19080154
 */
public class Request {
    
    private String reqTitle;
    private String reqType;
    private String reqDate;
    private String description;
    private String acceptedBy;

    public Request(String reqTitle, String reqType,String reqDate, String description, String acceptedBy) {
        this.reqTitle = reqTitle;
        this.reqType = reqType;
        this.reqDate = reqDate;
        this.description = description;
        this.acceptedBy = acceptedBy;
    }

    public String getReqTitle() {
        return reqTitle;
    }

    public void setReqTitle(String reqTitle) {
        this.reqTitle = reqTitle;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public String getReqDate() {
        return reqDate;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(String acceptedBy) {
        this.acceptedBy = acceptedBy;
    }
    
    
    public static void newRequesst (Request request) {
        try {

            //Openning DB connection
            Class.forName(Database.dbDriver);
            Connection connection = DriverManager.getConnection(Database.dbURL, Database.dbUsername, Database.dbPassword);
            Statement statement = connection.createStatement();

            

            //SQL INSERT statements for new Requests
            String queryRequest = "INSERT INTO request (reqTitle, reqType, reqDate, description, acceptedBy) VALUES (?,?,?,?,?)";

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
    
    public ArrayList<Request> requestSet(String type){
        
         ArrayList<Request> list = new ArrayList<>();
        try {

            //Openning DB connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/oop","lakisuru","Hannah<3");
            Statement statement = connection.createStatement();


            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from request where reqType="+type+";");
            
            Request request;
            
            while(rs.next()){
                request = new Request(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                list.add(request);     
            }

            
            connection.close();
        }catch(Exception e1){ System.out.println(e1);}  
        
        return list;
        
    }
    
            
    
    
}
