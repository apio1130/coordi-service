package com.coordi.service.api.adapter.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.coordi.service.application.common.exception.CommonException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CommonException.class)
	public ResponseEntity<ExceptionResponse> handleCommonException(CommonException e) {
		return ResponseEntity.status(e.getStatusCode())
							 .body(new ExceptionResponse(e.getStatusCode(), e.getMessage()));
	}

}
