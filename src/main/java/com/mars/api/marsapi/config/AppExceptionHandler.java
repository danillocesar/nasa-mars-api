package com.mars.api.marsapi.config;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path.Node;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mars.api.marsapi.i18n.Messages;
import com.mars.api.marsapi.i18n.MessagesProperties;
import com.mars.api.marsapi.rest.response.ErrorData;
import com.mars.api.marsapi.rest.response.ErrorResponse;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	@Autowired
	Messages messages;

	private static final Logger logger = LoggerFactory.getLogger(AppExceptionHandler.class);

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleInternalServerErrorException(Exception ex, WebRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		ErrorResponse body = new ErrorResponse(messages.get(MessagesProperties.INTERNAL_ERROR), ex.getMessage(), null);
		logError(ex);

		return handleExceptionInternal(ex, body, new HttpHeaders(), status, request);
	}
	
	public List<ErrorData> populateErrors(ErrorResponse response, BindingResult bindingResult) {
		List<ErrorData> errorsList = new ArrayList<ErrorData>();

		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			ErrorData error = new ErrorData(fieldError.getField(), fieldError.toString(), messages.get(fieldError), fieldError.getRejectedValue());
			errorsList.add(error);
		}
		response.setErrors(errorsList);

		return errorsList;
	}

	private void logError(Exception ex) {
		logger.error(ex.getMessage());
		logger.error(ex.getLocalizedMessage());
		ex.printStackTrace();
	}
}
