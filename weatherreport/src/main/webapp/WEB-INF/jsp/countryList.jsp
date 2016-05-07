<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="resources/scripts/angular.min.js"></script>
<script src="resources/scripts/weather.js"></script>
<script src="resources/scripts/WeatherService.js"></script>
<script src="resources/scripts/currentWeatherDirective.js"></script>
</head>
<body ng-app="weather" ng-controller="WeatherCtrl">

	<table>
		<tr>
			<td><select ng-model="cityId">
					<option ng-repeat="option in static.cityList"
						value="{{option.cityId}}">{{option.cityName}}</option>
			</select></td>

			<td><input type="button" value="Check Temperature"
				ng-click="getCityWeather()"></td>
		</tr>

	</table>
	<br>

	<disp-weather></disp-weather>

</body>
</html>