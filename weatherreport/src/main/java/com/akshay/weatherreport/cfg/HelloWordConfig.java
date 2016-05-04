package com.akshay.weatherreport.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWordConfig {

	@Bean
	public Void getName(){
		System.out.println("Akshay");
		return null;
	}
}
