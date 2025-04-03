package spring.boot.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import spring.boot.demo.interceptors.LoginInterceptor;

import javax.annotation.Resource;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/doc.html")
                .excludePathPatterns("/v3/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/templates/**")
                .excludePathPatterns("/error")
                .excludePathPatterns("/user/**");
    }

}
