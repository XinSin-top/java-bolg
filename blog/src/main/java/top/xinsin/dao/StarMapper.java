package top.xinsin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.xinsin.pojo.Star;

import java.util.ArrayList;

/**
 * Created On 7/21/22 7:59 PM
 *
 * @author xinsin
 * @version 1.0.0
 */
@Mapper
@Repository
public interface StarMapper {

    void insertStar(Integer articleId);

    void addStar(Integer articleId);

    void removeStar(Integer articleId);

    void addWatch(Integer articleId);

    ArrayList<Star> selectStar();


}
