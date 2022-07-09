package top.xinsin.controller;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.xinsin.pojo.User;
import top.xinsin.service.UserService;
import top.xinsin.util.ResultData;

import javax.servlet.http.HttpServletResponse;

/**
 * Created On 7/9/22 9:00 AM
 *
 * @author xinsin
 * @version 1.0.0
 */

@RestController()
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/api/login")
    public ResultData<JSONObject> login(@RequestBody User user, HttpServletResponse response) {
        return userService.login(user,response);
    }

    @PostMapping("/api/register")
    public ResultData<Integer> register(@RequestBody User user) {
        return userService.addUser(user);
    }
}
