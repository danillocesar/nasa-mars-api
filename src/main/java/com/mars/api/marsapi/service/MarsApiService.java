package com.mars.api.marsapi.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mars.api.marsapi.engine.rest.NasaApiRestEngine;
import com.mars.api.marsapi.engine.rest.properties.NasaApiProperties;
import com.mars.api.marsapi.mapper.NasaMarsResponseSol;
import com.mars.api.marsapi.rest.response.MarsTemperatureResponse;

@Service
public class MarsApiService {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	private NasaApiProperties nasaProperties;
	private NasaApiRestEngine nasaRestEngine;
	
	@PostConstruct
	public void initService() {
		this.nasaRestEngine = new NasaApiRestEngine(nasaProperties, restTemplate); 
	}
	public List<String> findSols() throws JsonMappingException, JsonProcessingException {
		Gson gson = new Gson();
		JsonObject  response = gson.fromJson(this.nasaRestEngine.getInsightWeather(), JsonObject.class);

		JsonArray solKeys = response.get("sol_keys").getAsJsonArray();
		List<String> result = new ArrayList<String>();
		
		for(JsonElement element : solKeys) {
			result.add(element.getAsString());
		}
		return result;
	}
	public MarsTemperatureResponse findInsightWeatherBySol(Integer sol) throws JsonMappingException, JsonProcessingException {
		Gson gson = new Gson();
		JsonObject  response = gson.fromJson(this.nasaRestEngine.getInsightWeather(), JsonObject.class);
		MarsTemperatureResponse marsResponse = new MarsTemperatureResponse();
		
		JsonArray solKeys = response.get("sol_keys").getAsJsonArray();
		
		ObjectMapper mapper = new ObjectMapper();
		
		if(sol != null && checkIfSolKeyExist(sol, solKeys)) {
			JsonElement solElement = response.get(sol.toString());
			NasaMarsResponseSol responseSol = mapper.readValue(gson.toJson(solElement), NasaMarsResponseSol.class);
			marsResponse.setAverageTemperature(responseSol.getResponseAT().getAverage());
		}else {
			float averageTemp = 0F;
			for(JsonElement element : solKeys) {
				JsonElement solElement = response.get(element.getAsString());
				NasaMarsResponseSol responseSol = mapper.readValue(gson.toJson(solElement), NasaMarsResponseSol.class);
				averageTemp += responseSol.getResponseAT().getAverage();
			}
			marsResponse.setAverageTemperature((averageTemp / solKeys.size()));
		}

		return marsResponse;
	}
	
	public boolean checkIfSolKeyExist(Integer sol, JsonArray solKeys) {
		for(JsonElement element : solKeys) {
			if(element.getAsString().equals(sol.toString())) return true;
		}
		return false;
	}
}
