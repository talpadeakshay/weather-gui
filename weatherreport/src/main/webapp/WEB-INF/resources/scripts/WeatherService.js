var services = angular.module('weather.service',[])
.constant('Url', {
	HOST: 'http://localhost:8080/weatherreport',
    GET_CITY_LIST: '/getCityList',
    GET_CITY_WEATHER: '/getCityWeather'
});

services.service('WeatherService', function($http, $q, Url){
	
	this.getCityList = function() {
		return sendRequest(Url.HOST + Url.GET_CITY_LIST);
	};
	
	this.getCityWeather = function(cityId){
		return sendRequest(Url.HOST + Url.GET_CITY_WEATHER + '/' +cityId);
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