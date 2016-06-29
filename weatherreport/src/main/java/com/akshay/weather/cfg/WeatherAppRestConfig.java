package com.akshay.weather.cfg;

import java.util.Arrays;
import java.util.LinkedList;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.ResourceProvider;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.spring.SpringResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.akshay.weather.service.rest.WeatherServiceJaxRs;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Configuration
public class WeatherAppRestConfig {

	@Bean
	public SpringBus cxf() {
		// APACS-7295: only one instance of SpringBus in sentinel
		// is it defined in the main @Configuration already, nothing
		// to do here.
		return null;
	}

	protected Server createRestServer(Object bean, String address) {
		/*
		 * JAXRSServerFactoryBean factory = (JAXRSServerFactoryBean)
		 * RuntimeDelegate.getInstance() .createEndpoint(application(),
		 * JAXRSServerFactoryBean.class);
		 */
		JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
		factory.setServiceBean(bean);
		/*
		 * List<Object> providers = QfsArrays.mutableList(new Object[] {
		 * jsonProvider(), jsonWriterInterceptor(), cachePolicyInterceptor(),
		 * errorHandlerProvider() }); providers.addAll(additionalProviders());
		 */
		SpringResourceFactory resoruceFactory = new SpringResourceFactory(bean.getClass().getName());

		LinkedList<ResourceProvider> resourceProviders = new LinkedList<ResourceProvider>();
		resourceProviders.add(resoruceFactory);
		
		factory.setResourceProviders(resourceProviders);

		factory.setProviders(Arrays.asList(new JacksonJsonProvider()));

		// factory.setProviders(providers);
		factory.setAddress(address);
		return factory.create();
	}

	/*
	 * protected Server createRestServer(Object service, String namespace,
	 * String version) { return createRestServer(service, "/" + version + "/" +
	 * namespace); }
	 */
	@Bean(destroyMethod = "destroy")

	@DependsOn({ "cxf" })
	public Server staticDataRestFulService() {
		WeatherServiceJaxRs rs = new WeatherServiceJaxRs();
		return createRestServer(rs, "/weatherrs");
	}

}
