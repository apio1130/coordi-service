package com.coordi.service.domain.product;

import java.math.BigInteger;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

	@Builder
	public Product(Long id, BigInteger price, Long categoryId, Long brandId, boolean isActive, String modifiedBy) {
		this.id = id;
		this.price = price;
		this.categoryId = categoryId;
		this.brandId = brandId;
		this.isActive = isActive;
		this.modifiedBy = modifiedBy;
	}

	private Long id;
	private BigInteger price;
	private Long categoryId;
	private Long brandId;
	private boolean isActive;
	private String modifiedBy;
}
