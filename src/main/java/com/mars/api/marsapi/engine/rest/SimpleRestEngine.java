package com.mars.api.marsapi.engine.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.mars.api.marsapi.engine.rest.properties.ApiProperties;

/**
 * @author danillo.mendonca
 * abstract class to use resttemplate with more ease
 */
public abstract class SimpleRestEngine {
	private ApiProperties properties;
	private RestTemplate restTemplate;
	
	public SimpleRestEngine(ApiProperties properties, RestTemplate restTemplate) {
		Assert.notNull(properties, "properties cannot be null");
		Assert.notNull(restTemplate, "restTemplate cannot be null");
		this.properties = properties;
		this.restTemplate = restTemplate;
	}
	/**
	 * Call resttemplate with a POST method and the response type parameter, in the url of the restproperties
	 * @param path of the api with a get method
	 * @param responseType class that will be used in the response type of the request
	 */
	protected <T> ResponseEntity<T> post(String path, Object object,  Class<T> responseType) {
		return restTemplate.postForEntity(properties.getUrl() + path,  RestUtils.getRequestEntity(object), responseType);
	}
	
	/**
	 * Call resttemplate with a GET method and the response type parameter, in the url of the restproperties
	 * @param path of the api with a get method
	 * @param responseType class that will be used in the response type of the request
	 */
	protected <T> ResponseEntity<T> get(String path, Class<T> responseType) {
		return restTemplate.exchange(properties.getUrl() + path, HttpMethod.GET, RestUtils.getRequestEntity(null), responseType);
	}
	
	public ApiProperties getProperties() {
		return properties;
	}
}
