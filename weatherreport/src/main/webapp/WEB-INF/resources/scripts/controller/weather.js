var weatherApp = angular.module('weather', [ 'weather.service' ,'weatherDirective']);

weatherApp.controller('WeatherCtrl',
		function($scope, WeatherService, $q, $http) {

			//load city list in the drop down
			var inits = [];
			$scope.static = [];
			var initCityList = WeatherService.getCityList().then(
					function(promise) {
						$scope.static.cityList = promise.data;
					});

			inits.push(initCityList);
			$q.all(inits);
			
			// on click of button get the city weather
			$scope.getCityWeather = function() {
				var cityId = $scope.cityId;			
				var cityWeather = WeatherService.getCityWeather(cityId).then(
					function(promise) {
						$scope.cityWeather = promise.data;
					});
				
			};
		});

