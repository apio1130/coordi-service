package com.coordi.service.api.adapter.recommendation;

import java.math.BigInteger;
import java.util.List;

import com.coordi.service.domain.recommendation.MinMaxPriceProducts;
import com.coordi.service.domain.recommendation.RecommendationProduct;

record MinMaxPriceProductResponse(String categoryName, List<PriceInfo> minPrice, List<PriceInfo> maxPrice) {

	static MinMaxPriceProductResponse from(MinMaxPriceProducts products) {
		RecommendationProduct minPriceProduct = products.getMinPriceProduct();
		RecommendationProduct maxPriceProduct = products.getMaxPriceProduct();
		return new MinMaxPriceProductResponse(products.getCategoryName(),
											  List.of(new PriceInfo(minPriceProduct.getBrandName(), minPriceProduct.getPrice())),
											  List.of(new PriceInfo(maxPriceProduct.getBrandName(), maxPriceProduct.getPrice())));
	}

	private record PriceInfo(String brandName, BigInteger price) {
	}
}
