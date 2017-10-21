package com.cjh.cc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class CcSApplication {

	public static void main(String[] args) {
		SpringApplication app=new SpringApplication(CcSApplication.class);
		app.setBannerMode(Banner.Mode.OFF);//关闭banner
		app.run(args);
	}
}
