package top.xinsin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.xinsin.interceptor.AuthenticationInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created On 7/8/22 9:01 PM
 *
 * @author xinsin
 * @version 1.0.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private final AuthenticationInterceptor authenticationInterceptor;

    @Autowired
    public InterceptorConfig(AuthenticationInterceptor authenticationInterceptor) {
        this.authenticationInterceptor = authenticationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).
                addPathPatterns("/**").
                excludePathPatterns(getExcludePathPatterns());
    }

    private List<String> getExcludePathPatterns() {
        List<String> excludePathPatterns = new ArrayList<>();
        excludePathPatterns.add("/api/login");
        excludePathPatterns.add("/api/selectArticle");
        excludePathPatterns.add("/api/selectArticleUUID/{uuid}");
        excludePathPatterns.add("/api/debug");
        excludePathPatterns.add("/api/register");
        excludePathPatterns.add("/api/getImages/{md5}");
        excludePathPatterns.add("/api/addWatch");
        excludePathPatterns.add("/api/selectStar");
        return excludePathPatterns;
    }
}
