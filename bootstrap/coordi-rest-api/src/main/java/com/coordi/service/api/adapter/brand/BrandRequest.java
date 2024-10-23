package com.coordi.service.api.adapter.brand;

import java.util.Objects;

record BrandRequest(String name, String userName) {
	BrandRequest {
		Objects.requireNonNull(name, "브랜드는 필수 정보입니다.");
		Objects.requireNonNull(userName, "사용자 정보는 필수 정보입니다.");
	}
}
