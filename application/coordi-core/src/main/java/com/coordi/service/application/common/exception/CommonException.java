package com.coordi.service.application.common.exception;

import lombok.Builder;

public class CommonException extends RuntimeException {

	@Builder
	public CommonException(int statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
	}

	private int statusCode;

	public int getStatusCode() {
		return statusCode;
	}
}
