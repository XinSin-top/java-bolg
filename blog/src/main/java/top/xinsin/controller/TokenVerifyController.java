package top.xinsin.controller;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xinsin.util.ResultData;

import java.util.HashMap;

/**
 * Created On 7/21/22 7:07 PM
 *
 * @author xinsin
 * @version 1.0.0
 */
@RestController
public class TokenVerifyController {

//    token验签,在拦截器中验证
    @GetMapping("/api/tokenVerify")
    public ResultData<JSONObject> tokenVerify() {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("verify", "success");
        return ResultData.success(new JSONObject(stringStringHashMap));
    }
}
