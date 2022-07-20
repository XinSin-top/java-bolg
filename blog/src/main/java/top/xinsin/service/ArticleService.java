package top.xinsin.service;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xinsin.dao.ArticleMapper;
import top.xinsin.pojo.Article;
import top.xinsin.util.ResultData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created On 7/20/22 8:07 PM
 *
 * @author xinsin
 * @version 1.0.0
 */

@Service
@Slf4j
public class ArticleService {

    private final ArticleMapper articleMapper;

    @Autowired

    public ArticleService(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    public ResultData<JSONObject> saveArticle(Article article) {
        Article article1 = articleMapper.selectArticleTitle(article.getTitle());
        if (article1 != null) {
            log.info("文章已存在,正在进行更新");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(new Date());
            article.setTime(format);
            articleMapper.updateArticle(article);
            return ResultData.success(new JSONObject());
        }else{
            log.info("文章不存在,正在进行插入");
            String uuid = UUID.randomUUID().toString().replace("-","");
            article.setUuid(uuid);
            Integer id = articleMapper.insertArticle(article);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",id);
            jsonObject.put("uuid",uuid);
            return ResultData.success(jsonObject);
        }
    }
    public ResultData<List<Article>> selectArticle() {
        log.info("查询文章");
        return ResultData.success(articleMapper.selectArticle());
    }
    public ResultData<JSONObject> selectArticleUUID(String uuid) {
        log.info("查询文章UUID");
        return ResultData.success(JSONObject.parseObject(JSONObject.toJSONString(articleMapper.selectArticleUUID(uuid))));
    }
}
