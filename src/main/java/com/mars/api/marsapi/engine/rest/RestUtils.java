package com.mars.api.marsapi.engine.rest;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.google.gson.Gson;

public class RestUtils {

	public static HttpEntity<String> getRequestEntity(Map<String, String> headers, Object entity) {
		HttpHeaders httpHeaders = new HttpHeaders();

		if (headers != null) {
			headers.forEach((key, value) -> httpHeaders.set(key, value));
		}

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		Gson gson = new Gson();
		return new HttpEntity<String>(gson.toJson(entity), httpHeaders);
	}

	public static HttpEntity<String> getRequestEntity(Object entity) {
		return getRequestEntity(null, entity);
	}
}
