package com.mars.api.marsapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mars.api.marsapi.rest.response.MarsTemperatureResponse;
import com.mars.api.marsapi.service.MarsApiService;

@RestController
@RequestMapping(value = "/mars")
public class MarsController {
	@Autowired
	MarsApiService marsApiService;
	
	@GetMapping({"/temperature", "/temperature/{sol}"})
	public MarsTemperatureResponse findTemperatureBySol(@PathVariable(required = false) Integer sol) throws JsonMappingException, JsonProcessingException {
		return marsApiService.findInsightWeatherBySol(sol);
	}
	
	@GetMapping("/sols")
	public List<String> findSols() throws JsonMappingException, JsonProcessingException {
		return marsApiService.findSols();
	}
}
