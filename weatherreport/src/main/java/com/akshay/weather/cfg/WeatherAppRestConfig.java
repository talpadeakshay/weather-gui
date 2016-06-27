package com.akshay.weather.cfg;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.akshay.weather.service.rest.WeatherServiceJaxRs;


@Configuration
public class WeatherAppRestConfig {
	
	
	public SpringBus cxf() {
		// APACS-7295: only one instance of SpringBus in sentinel
		// is it defined in the main @Configuration already, nothing
		// to do here.
		return null;
	}
	
	/*protected Server createRestServer(Object service, String namespace, String version) {
		return createRestServer(service, "/" + version + "/" + namespace);
	}
	
	@Bean(destroyMethod = "destroy")
	@DependsOn({ "cxf" })
	public Server staticDataRestFulService() {	
		WeatherServiceJaxRs rs = new WeatherServiceJaxRs();
		return createRestServer(rs, "/weatherrs");
	}*/
}
