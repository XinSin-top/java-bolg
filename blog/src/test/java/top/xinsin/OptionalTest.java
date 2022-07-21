package top.xinsin;

import org.junit.jupiter.api.Test;
import top.xinsin.pojo.Article;

import java.util.Optional;

/**
 * Created On 7/21/22 6:57 PM
 *
 * @author xinsin
 * @version 1.0.0
 */
public class OptionalTest {
    @Test
    void test() {
        Article article = new Article("1", "1", "1","1","2908");
        Optional<String > optional = Optional.ofNullable(article.getUuid());
        optional.ifPresent(System.out::println);
    }
}
