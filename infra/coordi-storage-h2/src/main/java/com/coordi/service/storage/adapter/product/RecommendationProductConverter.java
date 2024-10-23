package com.coordi.service.storage.adapter.product;

import com.coordi.service.domain.recommendation.RecommendationProduct;

import lombok.experimental.UtilityClass;

@UtilityClass
class RecommendationProductConverter {

	public static RecommendationProduct toModel(ProductInfo info) {
		return RecommendationProduct.builder()
									.price(info.getPrice())
									.brandId(info.getBrandId())
									.categoryId(info.getCategoryId())
									.build();
	}
}
