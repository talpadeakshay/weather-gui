package com.akshay.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeatherController {

	@RequestMapping("/list")
	public String getCountryList(){
		return "countryList";
	}
}
