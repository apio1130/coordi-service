package com.coordi.service.api.adapter.product;

import java.math.BigInteger;
import java.util.Objects;

record ProductRequest(BigInteger price, Long brandId, Long categoryId, String userName) {
	ProductRequest {
		Objects.requireNonNull(price, "상품 가격은 필수 정보입니다.");
		Objects.requireNonNull(brandId, "브랜드는 필수 정보입니다.");
		Objects.requireNonNull(categoryId, "카테고리는 필수 정보입니다.");
		Objects.requireNonNull(userName, "사용자 정보는 필수 정보입니다.");
	}
}
