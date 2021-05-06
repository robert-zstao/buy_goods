package com.robert.goods.config;

import com.robert.goods.fliter.UserVerifyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 注入拦截器
 * @Author robert
 * @Date 2021/3/10 17:33
 * @Version 1.0
 */
//@Configuration
public class WebConfigurer extends WebMvcConfigurationSupport {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("POST","GET","PUT","OPTIONS","DELETE").maxAge(360000).allowCredentials(true);
        super.addCorsMappings(registry);
    }
    /**
     * 解决跨域问题覆盖默认的SpringMVC配置，会导致Swagger2框架的页面赵不到故而需要加入该配置解决路径访问的问题
     * @param registry
     */
/*    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
        registry.addInterceptor(userVerifyInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public UserVerifyInterceptor userVerifyInterceptor() {
        return new UserVerifyInterceptor();
    }

}