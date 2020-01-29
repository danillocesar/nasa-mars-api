package com.mars.api.marsapi.engine.rest.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "nasa.gov.api")
public class NasaApiProperties extends ApiProperties {
	private String insightWeatherPath;

	public String getInsightWeatherPath() {
		return insightWeatherPath;
	}

	public void setInsightWeatherPath(String insightWeatherPath) {
		this.insightWeatherPath = insightWeatherPath;
	}
}
