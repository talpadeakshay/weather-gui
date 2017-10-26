package com.akshay.weather.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.akshay.weather.dto.impl.CityDto;
import com.akshay.weather.dto.impl.CityWeatherDto;
import com.akshay.weather.service.IWeatherService;
import com.akshay.weather.util.JsonReaderUtil;

@Service
public class WeatherService implements IWeatherService {

	@Autowired
	Environment env;

	@Value("${open.weather.map.url}")
	private String weatherMapUrl;

	@Value("${open.weather.map.appId}")
	private String weatherMapAppId;

	@Value("${open.weather.map.units}")
	private String weatherMapTempUnits;

	@Value("${open.weather.map.initial.city}")
	private String initaialCity;

	@Value("${open.weather.map.initial.city.id}")
	private String initialCityId;

	private List<CityDto> lstCity = new ArrayList<CityDto>();

	public List<CityDto> getCityList() {

		String[] arrInitialCity = initaialCity.split(",");
		String[] arrInitialCityId = initialCityId.split(",");
		CityDto dto = null;
		for (int i = 0; i < arrInitialCityId.length; i++) {
			dto = new CityDto(Long.valueOf(arrInitialCityId[i]), arrInitialCity[i]);
			lstCity.add(dto);
		}
		return lstCity;
	}

	public List<CityDto> addCity(String cityId, String cityName) {
		CityDto dto = new CityDto(Long.valueOf(cityId), cityName);
		lstCity.add(dto);
		return lstCity;
	}

	public CityWeatherDto getCityWeather(String cityId) {
		CityWeatherDto cityWeather = null;
		try {
			String url = weatherMapUrl + cityId + weatherMapAppId + weatherMapTempUnits;
			JSONObject json = JsonReaderUtil.readJsonFromUrl(url);
			JSONObject jsonMain = (JSONObject) json.get("main");
			JSONArray jsonWeather = (JSONArray) json.get("weather");
			Date updtDate = new Date(Long.valueOf(json.get("dt").toString()) * 1000);
			JSONObject jsonWeatherObj = (JSONObject) jsonWeather.get(0);
			JSONObject jsonWind = (JSONObject) json.get("wind");
			cityWeather = new CityWeatherDto();
			cityWeather.setCityId(Long.valueOf(cityId));
			cityWeather.setUpdatedDate(updtDate);
			cityWeather.setCityName(json.get("name").toString());
			cityWeather.setTemp(jsonMain.get("temp").toString());
			cityWeather.setWeatherDescription(jsonWeatherObj.get("description").toString());
			cityWeather.setWindSpeed(jsonWind.get("speed").toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return cityWeather;
	}

	public CityWeatherDto getCityWeather() {
		CityWeatherDto weather = new CityWeatherDto();
		weather.setCityCountry("Australia");
		weather.setCityId(1L);
		weather.setCityName("Sydney");
		weather.setTemp("40C");
		weather.setUpdatedDate(new Date());
		weather.setWeatherDescription("Cloudy");
		weather.setWindSpeed("10");
		return weather;
	}

}
