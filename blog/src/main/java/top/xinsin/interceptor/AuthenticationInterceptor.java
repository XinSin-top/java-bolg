package top.xinsin.interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.xinsin.enums.HttpCodes;
import top.xinsin.util.JwtTokenUtils;
import top.xinsin.util.ResultData;
import top.xinsin.util.StringUtils;

/**
 * Created On 7/8/22 9:01 PM
 *
 * @author xinsin
 * @version 1.0.0
 */
@Slf4j
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        if (StringUtils.OPTIONS.equals(request.getMethod())) {
            return true;
        }
        final String token = request.getHeader("Access-Token");
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Headers","*");
        ResultData<String> resultData;
        try {
            JwtTokenUtils.verify(token);
            return true;
        } catch (SignatureVerificationException e) {
            log.info("用户验证了无效签名");
            resultData = ResultData.failed(HttpCodes.INVALID_TOKEN,"无效签名");
        }catch (TokenExpiredException e){
            log.info("用户验证的签名已过期");
            resultData = ResultData.failed(HttpCodes.INVALID_TOKEN,"签名已过期");
        }catch (AlgorithmMismatchException e){
            log.info("用户验证的token算法不一致");
            resultData = ResultData.failed(HttpCodes.HTTP_CODES200,"token算法不一致");
        }catch (Exception e){
            log.info("token无效或者是空的");
            resultData = ResultData.failed(HttpCodes.ACCESS_DENIED,"无权限访问请先登陆");
        }

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONObject.toJSONString(resultData));
        return false;
    }
}
