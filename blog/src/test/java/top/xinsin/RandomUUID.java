package top.xinsin;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * Created On 7/20/22 8:13 PM
 *
 * @author xinsin
 * @version 1.0.0
 */
public class RandomUUID {
    @Test
    void Test01(){
        String s = UUID.randomUUID().toString();
        s = s.replace("-","");
        System.out.println(s);
    }
}
