package com.akshay.weather.dto.impl;

import java.util.Date;

public class CityWeatherDto {

	protected Long cityId;
	protected String cityName;
	protected String cityCountry;
	protected Date updatedDate;
	protected String weatherDescription;
	protected String temp;
	protected String windSpeed;

	private static final String DEGREE = "\u00b0";
	private static final String SPEED_UNIT = "mtr/sec";

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCountry() {
		return cityCountry;
	}

	public void setCityCountry(String cityCountry) {
		this.cityCountry = cityCountry;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	public String getTemp() {
		return temp + " " + DEGREE + "C";
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getWindSpeed() {
		return windSpeed + " " + SPEED_UNIT;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

}
