package top.xinsin.service;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xinsin.dao.UserMapper;
import top.xinsin.enums.HttpCodes;
import top.xinsin.pojo.User;
import top.xinsin.util.JwtTokenUtils;
import top.xinsin.util.ResultData;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created On 7/9/22 8:53 AM
 *
 * @author xinsin
 * @version 1.0.0
 */
@Slf4j
@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public ResultData<JSONObject> login(User user, HttpServletResponse response){
        log.info("进入登陆接口:username={}",user.getUsername());
        JSONObject jsonObject = new JSONObject();
        user.setPassword(DigestUtils.sha512Hex(user.getPassword()));
        User user1 = userMapper.login(user);
        if (user1 != null){
            Map<String,String> payload = new HashMap<>(10);
            payload.put("id",String.valueOf(user1.getId()));
            payload.put("username",user1.getUsername());
            String token = JwtTokenUtils.getToken(payload);
            response.setHeader("token",token);
            response.setHeader("Access-Control-Expose-Headers","token");
            jsonObject.fluentPut("canLogin",true);
        }else{
            jsonObject.fluentPut("canLogin",false);
            return ResultData.failed(HttpCodes.HTTP_CODES501,jsonObject);
        }
        return ResultData.success(jsonObject);
    }
    public ResultData<Integer> addUser(User user){
        log.info("进入添加用户接口:username={}",user.getUsername());
        user.setPassword(DigestUtils.sha512Hex(user.getPassword()));
        int register = userMapper.register(user);
        return ResultData.success(register);
    }
}
