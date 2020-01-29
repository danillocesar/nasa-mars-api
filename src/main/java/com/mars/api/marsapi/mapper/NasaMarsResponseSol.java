package com.mars.api.marsapi.mapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaMarsResponseSol {
	@JsonProperty("AT")
	private NasaMarsResponseAT responseAT;

	public NasaMarsResponseAT getResponseAT() {
		return responseAT;
	}

	public void setResponseAT(NasaMarsResponseAT responseAT) {
		this.responseAT = responseAT;
	}
}
