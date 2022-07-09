package top.xinsin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.xinsin.pojo.User;

/**
 * Created On 7/9/22 8:50 AM
 *
 * @author xinsin
 * @version 1.0.0
 */

@Mapper
@Repository
public interface UserMapper {
    User login(User user);
    int register(User user);
}
