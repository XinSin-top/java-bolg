package top.xinsin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created On 7/20/22 10:03 AM
 *
 * @author xinsin
 * @version 1.0.0
 */

@Data
@NoArgsConstructor
public class Images {
    private Integer id;
    private String url;
    private String type;
    private Long size;
    private String md5;
    private Integer isdel;

    public Images(String url, String type, Long size, String md5) {
        this.url = url;
        this.type = type;
        this.size = size;
        this.md5 = md5;
    }
}
