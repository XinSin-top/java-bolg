package top.xinsin.controller;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.xinsin.pojo.Star;
import top.xinsin.service.StarService;
import top.xinsin.util.ResultData;

import java.util.List;

/**
 * Created On 7/21/22 8:09 PM
 *
 * @author xinsin
 * @version 1.0.0
 */
@RestController
public class StarController {

    private final StarService starService;

    @Autowired
    public StarController(StarService starService) {
        this.starService = starService;
    }

    @GetMapping("/api/addStar")
    public void addStar(@RequestParam("articleId")Integer articleId) {
        starService.addStar(articleId);
    }
    @GetMapping("/api/removeStar")
    public void removeStar(@RequestParam("articleId")Integer articleId) {
        starService.removeStar(articleId);
    }
    @GetMapping("/api/addWatch")
    public void addWatch(@RequestParam("articleId")Integer articleId) {
        starService.addWatch(articleId);
    }
    @GetMapping("/api/selectStar")
    public ResultData<List<Star>> selectStar() {
        return starService.selectStar();
    }
}
