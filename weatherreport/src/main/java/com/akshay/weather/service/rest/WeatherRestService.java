package com.akshay.weather.service.rest;

import javax.ws.rs.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.weather.util.JsonReader;

@RestController
public class WeatherRestService {

	@RequestMapping("/getCityList")
	public String getCityList() {
		String json = null;
		try {
			json = JsonReader.getJsonListFromFile("D:/programs/git/weather-gui/weatherreport/src/main/resources/weather/city.list.json").toString();
		} catch (Exception e) {
			e.printStackTrace();
		}		 
		return json;
	}
	
	@RequestMapping("/getCityWeather/{cityId}")
	public String getCityWeather(@PathParam("cityId") String cityId) {
		String json = null;
		try {
			json = JsonReader.readJsonFromUrl("http://api.openweathermap.org/data/2.5/forecast/city?id=524901&APPID=816150473629483737aadaf7fa40c57e&units=metric").toString();
		} catch (Exception e) {
			e.printStackTrace();
		}		 
		return json;
	}
}
