package top.xinsin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.xinsin.interceptor.AuthenticationInterceptor;

/**
 * Created On 7/8/22 9:01 PM
 *
 * @author xinsin
 * @version 1.0.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticationInterceptor()).
                //拦截
                addPathPatterns("/**").
                //放行登录接口
                excludePathPatterns("/api/login").
                //放行文章接口
                excludePathPatterns("/api/getArticles").
                //放行注册接口
                excludePathPatterns("/api/getArticleDetails").
                //放行调试接口
                excludePathPatterns("/api/debug").

                excludePathPatterns("/api/register");
    }
}
