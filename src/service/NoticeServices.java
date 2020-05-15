/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.swing.JTable;
import model.Notice;
/**
 *
 * @author Semasinghe L.S. IT19051130
 */
public interface NoticeServices {
    public void newNotice(Notice notice);
    public void DeleteSelectedRow(JTable table);
    
}
