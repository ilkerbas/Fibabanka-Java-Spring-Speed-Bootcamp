package com.ilkerbas.spring.orm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {

	@Bean
	public MyBean myBean() {
		MyBean myBean = new MyBean();
		myBean.setMyLong(300);
		myBean.setMyString("Godoro");
		myBean.setMyDouble(34.56);
		return myBean;
	}
}
