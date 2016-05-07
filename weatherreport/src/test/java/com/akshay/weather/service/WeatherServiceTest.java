package com.akshay.weather.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.akshay.weather.cfg.WeatherTestConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { WeatherTestConfig.class })
public class WeatherServiceTest {

	@Autowired
	IWeatherService service;

	@Test
	public void loadInitialCityList() {
		Assert.assertNotNull(service.getCityList());
	}
	
	@Test
	public void getCityWeather() {
		Assert.assertNotNull(service.getCityWeather("2147714"));
	}
}
