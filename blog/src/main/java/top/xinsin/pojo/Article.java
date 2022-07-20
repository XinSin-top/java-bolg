package top.xinsin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * Created On 7/9/22 8:20 AM
 *
 * @author xinsin
 * @version 1.0.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Integer id;
    private String article;
    private String title;
    private String author;
    private String time;
    private String uuid;
    private Integer isdel;

    public Article(String article, String title, String author) {
        this.article = article;
        this.title = title;
        this.author = author;
    }

    public Article(String article, String title, String author, String time, String uuid) {
        this.article = article;
        this.title = title;
        this.author = author;
        this.time = time;
        this.uuid = uuid;
    }
}
