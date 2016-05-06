var services = angular.module('weather.service',[])
.constant('Url', {
	HOST: 'http://localhost:8080/weatherreport',
    WEATHER_CITY_LIST: '/getCityList'    
});

services.service('WeatherService', function($http, $q, Url){
	
	this.getCityList = function() {
		return sendRequest(Url.HOST + Url.WEATHER_CITY_LIST);
	};
	
	var sendRequest = function(url) {
        var promise = $http.get(url)
        .success(function (data, status, headers, config) {
            return data.data;
        })
        .error(function (data, status, headers, config) {
            return [];
            console.error(status);
        });
        return promise;
    }
});