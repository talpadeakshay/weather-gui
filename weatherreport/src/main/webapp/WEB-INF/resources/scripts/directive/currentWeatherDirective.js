var app = angular.module('weatherDirective', []);

app.controller('Controller', [ '$scope', function($scope) {
	$scope.customer = {
		name : 'Naomi',
		address : '1600 Amphitheatre'
	};
} ]);

app.directive('dispWeather', function() {
	return {
		replace : 'false',
		template : '<span ng-if="cityWeather"> <table border="1" width="50%"> <tr> <th width="25%" align="left">City</th><td>{{cityWeather.cityName}}</td></tr><tr><th align="left">Updated time</th><td>{{cityWeather.updatedDate | date:\'medium\'}}</td></tr>	<tr><th align="left">Weather</th><td>{{cityWeather.weatherDescription}}</td></tr><tr><th align="left">Temperature</th><td>{{cityWeather.temp}}</td>	</tr>	<tr>		<th align="left">Wind</th>		<td>{{cityWeather.windSpeed}}</td>	</tr></table></span>'
		/*templateUrl : 'resources/weatherTable.jsp'*/
	};
});