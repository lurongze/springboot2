import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gz000172 on 2018/6/28.
 */
public class Test {
    public static void main(String[] args) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date today = new Date();
            String formatToday = formatter.format(today);
            Date ss = new java.sql.Date(today.getTime());
            System.out.println("######TIME:"+ ss);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
