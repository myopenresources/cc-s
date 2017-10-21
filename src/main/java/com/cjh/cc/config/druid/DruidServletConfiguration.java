package com.cjh.cc.config.druid;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

/**
 * druid servlet
 */
@Configuration
public class DruidServletConfiguration {

    @Autowired
    private Environment env;
    @Bean
    public ServletRegistrationBean druidStatViewServletBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), env.getProperty("druid.urlMapper"));
        Map<String,String> params = new HashMap<>();
        params.put("loginUsername",env.getProperty("druid.loginUsername"));
        params.put("loginPassword",env.getProperty("druid.loginPassword"));
        params.put("resetEnable",env.getProperty("druid.resetEnable"));
        servletRegistrationBean.setInitParameters(params);
        return servletRegistrationBean;
    }
}
