package com.akshay.weather.dto.impl;

public class CityDto {
	protected Long cityId;
	protected String cityName;

	public CityDto() {
		super();
	}

	public CityDto(Long cityId, String cityName) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
	}

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

}
