package com.akshay.weather.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.akshay.weather.cfg.WeatherTestConfig;
import com.akshay.weather.dto.impl.CityWeatherDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { WeatherTestConfig.class })
public class WeatherServiceTest {

	@Autowired
	IWeatherService service;

	@Test
	public void loadInitialCityList() {
		Assert.assertEquals(3, service.getCityList().size());
	}

	@Test
	public void getCityWeather() {
		CityWeatherDto dto = service.getCityWeather("2147714");
		Assert.assertEquals("Sydney", dto.getCityName());
	}

	@Test
	public void addCity() {
		Assert.assertEquals(4, service.addCity("2153391", "Perth").size());
	}
}
