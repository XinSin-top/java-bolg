package top.xinsin.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import top.xinsin.pojo.Article;

import java.util.ArrayList;

/**
 * Created On 7/20/22 8:02 PM
 *
 * @author xinsin
 * @version 1.0.0
 */
@Service
@Repository
public interface ArticleMapper {

    void insertArticle(Article article);

    Article selectArticleTitle(String title);
    Article selectArticleUuid(String uuid);

    void updateArticle(Article article);
    ArrayList<Article> selectArticle();

    Article selectArticleUUID(String uuid);

    Integer selectArticleId(String uuid);
}
