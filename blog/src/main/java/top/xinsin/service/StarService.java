package top.xinsin.service;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xinsin.dao.StarMapper;
import top.xinsin.pojo.Star;
import top.xinsin.util.ResultData;

import java.util.List;

/**
 * Created On 7/21/22 8:06 PM
 *
 * @author xinsin
 * @version 1.0.0
 */

@Service
@Slf4j
public class StarService {
    private final StarMapper starMapper;

    @Autowired
    public StarService(StarMapper starMapper) {
        this.starMapper = starMapper;
    }

    public void addStar(Integer articleId) {
        log.info("addStar articleId: {}", articleId);
        starMapper.addStar(articleId);
    }
    public void removeStar(Integer articleId) {
        log.info("removeStar articleId:{}", articleId);
        starMapper.removeStar(articleId);
    }
    public void addWatch(Integer articleId) {
        log.info("addWatch articleId:{}", articleId);
        starMapper.addWatch(articleId);
    }
    public ResultData<List<Star>> selectStar() {
        log.info("selectStar");
        return ResultData.success(starMapper.selectStar());
    }
    public void insertStar(Integer articleId) {
        log.info("insertStar articleId:{}", articleId);
        starMapper.insertStar(articleId);
    }
}
