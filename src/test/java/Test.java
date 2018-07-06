import com.lrz.utils.HelperUtil;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gz000172 on 2018/6/28.
 */
public class Test {
    public static void main(String[] args) {

        String pass = "123456";
        String encode = HelperUtil.encodePassword(pass);

        System.out.println(encode);

    }
}
