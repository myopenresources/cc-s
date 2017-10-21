package com.cjh.cc.config.mybatis;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * mybatis配置
 */
@Configuration
//@MapperScan("com.cjh.cc.*.*.mapper")
public class MyBatisConfig {

    @Autowired
    private Environment env;

    @Bean
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(env.getProperty("mybatis.config-location")));
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + env.getProperty("mybatis.mapper-locations");
        sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(dataSource());

        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", env.getProperty("pageHelper.reasonable"));
        properties.setProperty("supportMethodsArguments", env.getProperty("pageHelper.supportMethodsArguments"));
        properties.setProperty("returnPageInfo", env.getProperty("pageHelper.returnPageInfo"));
        properties.setProperty("params", env.getProperty("pageHelper.params"));
        pageHelper.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});

        return sqlSessionFactoryBean;
    }

    private DataSource dataSource() {
        Map<String,Object> properties=new HashMap<>();
        properties.put(DruidDataSourceFactory.PROP_DRIVERCLASSNAME,env.getProperty("spring.datasource.driverClassName"));
        properties.put(DruidDataSourceFactory.PROP_URL,env.getProperty("spring.datasource.url"));
        properties.put(DruidDataSourceFactory.PROP_USERNAME,env.getProperty("spring.datasource.username"));
        properties.put(DruidDataSourceFactory.PROP_PASSWORD,env.getProperty("spring.datasource.password"));
        //添加统计、SQL注入、日志过滤器
        properties.put(DruidDataSourceFactory.PROP_FILTERS,env.getProperty("druid.propFilters"));
        //sql合并，慢查询定义为5s
        properties.put(DruidDataSourceFactory.PROP_CONNECTIONPROPERTIES,env.getProperty("druid.propConnectionProperties"));
        try {
            return DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
