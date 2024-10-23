package com.coordi.service.domain.recommendation;

import java.math.BigInteger;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecommendationProduct {

	@Builder
	public RecommendationProduct(Long id, BigInteger price, Long brandId, String brandName,
								 Long categoryId, String categoryName) {
		this.id = id;
		this.price = price;
		this.brandId = brandId;
		this.brandName = brandName;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	private Long id;
	private BigInteger price;
	private Long brandId;
	private String brandName;
	private Long categoryId;
	private String categoryName;

	public void changeCategoryName(String name) {
		this.categoryName = name;
	}

	public void changeBrandName(String name) {
		this.brandName = name;
	}
}
