package com.akshay.weather.service;

import java.util.List;

import com.akshay.weather.dto.impl.CityDto;
import com.akshay.weather.dto.impl.CityWeatherDto;

public interface IWeatherService {
	public List<CityDto> getCityList();

	public CityWeatherDto getCityWeather(String cityId);

	public CityWeatherDto getCityWeather();

	public List<CityDto> addCity(String cityId, String cityName);
}
