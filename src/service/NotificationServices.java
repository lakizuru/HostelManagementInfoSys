/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.swing.JTable;
import model.Notification;

/**
 *
 * @author Semasinghe L.S. IT19051130
 */
public interface NotificationServices {
    public void newNotification(Notification notif);
    public void seenNotification(JTable table);
    public void deleteNotification(JTable table);
}
