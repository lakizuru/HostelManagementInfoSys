package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
    
    
    
            
    
    
}
