package com.cjh.cc.config.druid;

import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * druid过滤器
 */
@Configuration
public class DruidFilterConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public FilterRegistrationBean druidStatFilterBean() {
        FilterRegistrationBean druidStatFilterBean=new FilterRegistrationBean(new WebStatFilter());
        List<String> urlPattern=new ArrayList<>();
        urlPattern.add( env.getProperty("druid.urlPattern"));
        druidStatFilterBean.setUrlPatterns(urlPattern);
        Map<String,String> initParams=new HashMap<>();
        initParams.put("exclusions", env.getProperty("druid.exclusions"));
        druidStatFilterBean.setInitParameters(initParams);
        return druidStatFilterBean;
    }
}
