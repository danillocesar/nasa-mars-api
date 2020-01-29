package com.mars.api.marsapi.rest.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityUtil {
	public static ResponseEntity<ApiResponse> okResponseEntity(String message){
		return new ResponseEntity<ApiResponse>(new ApiResponse(message), HttpStatus.OK);
	}
	public static ResponseEntity<ApiResponse> okResponseEntity(String message, Object response){
		return new ResponseEntity<ApiResponse>(new ApiResponse(message, response), HttpStatus.OK);
	}
	public static ResponseEntity<ApiResponse> unprocessableResponseEntity(String message, Object response){
		return new ResponseEntity<ApiResponse>(new ApiResponse(message, response), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	public static ResponseEntity<ApiResponse> createdResponseEntity(String message, Object response){
		return new ResponseEntity<ApiResponse>(new ApiResponse(message, response), HttpStatus.CREATED);
	}
	public static ResponseEntity<ApiResponse> notFoundResponseEntity(String message, Object response){
		return new ResponseEntity<ApiResponse>(new ApiResponse(message, null), HttpStatus.NOT_FOUND);
	}
}
