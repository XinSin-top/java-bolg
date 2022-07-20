package top.xinsin.controller;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.xinsin.pojo.Article;
import top.xinsin.service.ArticleService;
import top.xinsin.util.ResultData;

import java.util.List;

/**
 * Created On 7/20/22 8:22 PM
 *
 * @author xinsin
 * @version 1.0.0
 */
@RestController
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/api/saveArticle")
    public ResultData<JSONObject> saveArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }
    @GetMapping("/api/selectArticle")
    public ResultData<List<Article>> selectArticle() {
        return articleService.selectArticle();
    }
    @GetMapping("/api/selectArticleUUID/{uuid}")
    public ResultData<JSONObject> selectArticleUUID(@RequestParam String uuid) {
        return articleService.selectArticleUUID(uuid);
    }

}
