/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author lakis
 */
public class DateTime {
    public static String sqlTime(){
        Date dateTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(dateTime);        
    }
}
