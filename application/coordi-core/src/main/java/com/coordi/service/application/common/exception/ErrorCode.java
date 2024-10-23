package com.coordi.service.application.common.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorCode {
	DUPLICATE_KEY(400, "%s 값이 중복입니다."),
	NOT_FOUND_DATA(400, "%s 값이 존재하지 않습니다."),
	;

	private final int statusCode;
	private final String message;

	public CommonException toException(String... values) {
		return CommonException.builder()
							  .statusCode(statusCode)
							  .message(message.formatted(values))
							  .build();
	}
}
