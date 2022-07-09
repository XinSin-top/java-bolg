package top.xinsin.pojo;

import lombok.Data;

/**
 * Created On 7/9/22 8:31 AM
 *
 * @author xinsin
 * @version 1.0.0
 */
@Data
public class Star {
    private Integer id;
    private Integer articleStar;
    private Integer articleId;
    private Integer articleWatch;
    private Integer isdel;
}
