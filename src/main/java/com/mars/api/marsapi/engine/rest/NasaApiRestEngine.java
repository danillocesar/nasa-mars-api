package com.mars.api.marsapi.engine.rest;

import org.springframework.web.client.RestTemplate;

import com.mars.api.marsapi.engine.rest.properties.NasaApiProperties;

public class NasaApiRestEngine extends SimpleRestEngine{
	
	public NasaApiRestEngine(NasaApiProperties properties, RestTemplate restTemplate) {
		super(properties, restTemplate);
	}

	public String getInsightWeather() {
		return get(getProperties().getInsightWeatherPath() + "?api_key="+ getProperties().getToken()+"&feedtype=json&ver=1.0", String.class).getBody();
	}
	
	public NasaApiProperties getProperties() {
		return (NasaApiProperties) super.getProperties();
	}
}
