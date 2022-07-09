package top.xinsin.pojo;

import lombok.Data;

/**
 * Created On 7/9/22 8:20 AM
 *
 * @author xinsin
 * @version 1.0.0
 */

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer isdel;
}