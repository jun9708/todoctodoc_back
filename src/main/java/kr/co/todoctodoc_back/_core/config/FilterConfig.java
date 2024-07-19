package kr.co.todoctodoc_back._core.config;


import kr.co.todoctodoc_back._core.filter.JwtAuthorizationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    FilterRegistrationBean<JwtAuthorizationFilter> jwtFilter(){
        FilterRegistrationBean<JwtAuthorizationFilter> bean =
                new FilterRegistrationBean<>(new JwtAuthorizationFilter());
        bean.addUrlPatterns("");
        bean.setOrder(0);
        return bean;
    }
}
