package com.akshay.weather.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.weather.dto.impl.CityDto;
import com.akshay.weather.dto.impl.CityWeatherDto;
import com.akshay.weather.service.IWeatherService;

@RestController
public class WeatherRestService {

	@Autowired
	private IWeatherService service;

	@RequestMapping(value = "/getCityList", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<CityDto> getCityList() {
		return service.getCityList();
	}

	@RequestMapping("/getCityWeather/{cityId}")
	public CityWeatherDto getCityWeather(@PathVariable("cityId") String cityId) {

		return service.getCityWeather();
	}
}
