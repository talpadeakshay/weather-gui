<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="resources/scripts/angular.min.js"></script>
<script src="resources/scripts/weather.js"></script>
<script src="resources/scripts/WeatherService.js"></script>
</head>
<body ng-app="weather" ng-controller="WeatherCtrl">

	<table>
		<tr>
			<td><select ng-model="cityId">
					<option ng-repeat="option in static.cityList"
						value="{{option.cityId}}">{{option.cityName}}</option>
			</select></td>
		
			<td><input type="button" value="Check Temperature"  ng-click="getCityWeather()"></td>
		</tr>
		
	</table>
	<br>
	<table border="1" width="50%">
		<tr>
			<th width="25%" align="left">City</th>
			<td>{{cityWeather.cityName}}</td>
		</tr>
		<tr>
			<th align="left">Updated time</th>
			<td>{{cityWeather.updatedDate}}</td>
		</tr>
		<tr>
			<th align="left">Weather</th>
			<td>{{cityWeather.weatherDescription}}</td>
		</tr>
		<tr>
			<th align="left">Temperature</th>
			<td>{{cityWeather.temp}}</td>
		</tr>
		<tr>
			<th align="left">Wind</th>
			<td>{{cityWeather.windSpeed}}</td>
		</tr>
	</table>
</body>
</html>