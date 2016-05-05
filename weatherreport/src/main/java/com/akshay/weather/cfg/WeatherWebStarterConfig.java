package com.akshay.weather.cfg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({ "com.akshay.weather" })
public class WeatherWebStarterConfig {
	protected static final Logger LOGGER = LoggerFactory.getLogger(WeatherWebStarterConfig.class);
		
	@Bean
	public InternalResourceViewResolver viewResolver() {		
		InternalResourceViewResolver viewResolver 
                         = new InternalResourceViewResolver();		
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
