package top.xinsin.pojo;

import lombok.Data;

import java.sql.Date;

/**
 * Created On 7/9/22 8:20 AM
 *
 * @author xinsin
 * @version 1.0.0
 */

@Data
public class Article {
    private Integer id;
    private String article;
    private String title;
    private String author;
    private Date time;
    private String uuid;
    private Integer isdel;
}
