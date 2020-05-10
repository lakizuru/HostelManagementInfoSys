package util;

import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author Semasinghe L.S. IT19051130
 */
public class DateTime {
    public static String sqlTime(){
        Date dateTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(dateTime);        
    }
}
