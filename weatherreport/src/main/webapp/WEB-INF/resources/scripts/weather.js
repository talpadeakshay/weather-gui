var weatherApp = angular.module('weather', [ 'weather.service' ]);

weatherApp.controller('WeatherCtrl',
		function($scope, WeatherService, $q, $http) {

			var inits = [];
			$scope.static = [];
			var initCityList = WeatherService.getCityList().then(
					function(promise) {
						$scope.static.cityList = promise.data;
					});

			inits.push(initCityList);
			$q.all(inits);
			
			$scope.getCityWeather = function(cityId) {

				var cityWeather = WeatherService.getCityWeather(cityId).then(
					function(promise) {
						$scope.static.cityWeather = promise.data;
					});
				
			};
		});

