package com.akshay.weather.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.akshay.weather.service.IWeatherService;
import com.akshay.weather.service.impl.WeatherService;

@PropertySource(value = { "classpath:/weather/weatherApi.properties" })
public class WeatherTestConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public IWeatherService getWeatherService() {
		return new WeatherService();
	}

}
