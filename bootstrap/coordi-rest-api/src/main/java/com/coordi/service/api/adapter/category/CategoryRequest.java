package com.coordi.service.api.adapter.category;

import java.util.Objects;

public record CategoryRequest(String name, String userName) {
	public CategoryRequest {
		Objects.requireNonNull(name, "카테고리는 필수 정보입니다.");
		Objects.requireNonNull(userName, "사용자 정보는 필수 정보입니다.");
	}
}
