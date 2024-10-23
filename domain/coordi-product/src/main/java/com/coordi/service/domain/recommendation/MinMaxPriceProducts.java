package com.coordi.service.domain.recommendation;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MinMaxPriceProducts {

	@Builder
	public MinMaxPriceProducts(String categoryName, RecommendationProduct minPriceProduct,
							   RecommendationProduct maxPriceProduct) {
		this.categoryName = categoryName;
		this.minPriceProduct = minPriceProduct;
		this.maxPriceProduct = maxPriceProduct;
	}

	private String categoryName;
	private RecommendationProduct minPriceProduct;
	private RecommendationProduct maxPriceProduct;

}
