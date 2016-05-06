package com.akshay.weather.dto;

import java.util.List;
import java.util.Map;

public class CityDto {

	private Long cityId;
	private String cityName;
	private String cityCountry;
	private List<Map<String, Long>> cityCoordinates;

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

	public List<Map<String, Long>> getCityCoordinates() {
		return cityCoordinates;
	}

	public void setCityCoordinates(List<Map<String, Long>> cityCoordinates) {
		this.cityCoordinates = cityCoordinates;
	}

	@Override
	public String toString() {
		return "CityDto [cityId=" + cityId + ", cityName=" + cityName
				+ ", cityCountry=" + cityCountry + ", cityCoordinates="
				+ cityCoordinates + "]";
	}

}
