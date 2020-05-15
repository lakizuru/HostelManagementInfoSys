/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import view.AdminDashboard;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Perera A.A.K.B IT19080154
 */
public class TableFunctions {
    
    public static void RetrieveToTable(JTable table,String query){
        
        
        try {
            // TODO add your handling code here:
            Statement st=Database.connectDB().createStatement();
            ResultSet rs = st.executeQuery(query);
            

           
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            int c = model.getColumnCount();
            Object[] row = new Object[c];

            
            
            while(rs.next()){
                
                
                
                    for(int i=0;i<=(c-1);i++){
                        row[i] = rs.getObject(i+1);
                    }
                
                model.addRow(row);
                    
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /*public static void DeleteSelectedRow(JTable table){
    
    try{
    String C1;
    int i = table.getSelectedRow();
    
    
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    C1 = model.getValueAt(i, 0).toString();
    
    if(table.getSelectedRow() != -1) {
    
    model.removeRow(table.getSelectedRow());
    JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
    }
    
    try{
    Statement st = Database.connectDB().createStatement();
    String query = "delete from guest where username='"+C1+"';";
    st.executeUpdate(query);
    
    
    
    }catch(ArrayIndexOutOfBoundsException e1){JOptionPane.showMessageDialog(null, "Please Select a Row. \n" , "Please Select a Row!", JOptionPane.ERROR_MESSAGE);
    
    }
    }catch(Exception e){JOptionPane.showMessageDialog(null, "Please Select a Row! \n" , "Please Select a Row.", JOptionPane.ERROR_MESSAGE);
    }
    
    }*/
    
    
    public static void ClearTable(JTable table){
    
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);
    
    }
    
    /*
    public static void updateTable(JTable table,String query){
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        //Remove existing records
        for (int i = table.getRowCount(); i > 0; i--){
            model.removeRow(i-1);
        }
        
        //Regenerate table
        RetrieveToTable(table, query);
        
    }
    */
}
