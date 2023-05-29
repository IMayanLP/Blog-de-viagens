package BR.com.app.blog.classes.utils;

import java.text.DateFormat;
import java.util.Date;

public class Utils {
    public static String getDate(){
        Date d = new Date();
        return java.text.DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(d);
    }
}
