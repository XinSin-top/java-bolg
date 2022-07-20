package top.xinsin;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created On 7/20/22 8:24 PM
 *
 * @author xinsin
 * @version 1.0.0
 */
public class SQLDATETest {
    @Test
    void Test01(){
//        2022-07-20 20:28:40
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        System.out.println(format);

    }
}
