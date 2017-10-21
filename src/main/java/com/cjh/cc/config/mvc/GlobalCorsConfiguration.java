package com.cjh.cc.config.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GlobalCorsConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(Boolean.valueOf(env.getProperty("cors.allowCredentials")));
        config.addAllowedOrigin(env.getProperty("cors.allowedOrigin"));
        config.addAllowedHeader(env.getProperty("cors.allowedHeader"));
        config.addAllowedMethod(env.getProperty("cors.allowedMethod"));
        source.registerCorsConfiguration(env.getProperty("cors.registerPath"), config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}

