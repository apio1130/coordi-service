package com.coordi.service.api.adapter.recommendation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.coordi.service.domain.recommendation.RecommendationProduct;

import lombok.Getter;

@Getter
class CategoryMinPriceProductsResponse {

	CategoryMinPriceProductsResponse(BigInteger totalPrice, List<PriceInfo> products) {
		this.totalPrice = totalPrice;
		this.products = products;
	}

	private final BigInteger totalPrice;

	private final List<PriceInfo> products;

	public static CategoryMinPriceProductsResponse from(List<RecommendationProduct> minPriceProductsByCategory) {
		BigInteger totalPrice = BigInteger.ZERO;
		List<PriceInfo> products = new ArrayList<>();
		for (RecommendationProduct product : minPriceProductsByCategory) {
			products.add(new PriceInfo(product.getCategoryName(), product.getBrandName(), product.getPrice()));
			totalPrice = totalPrice.add(product.getPrice());
		}
		return new CategoryMinPriceProductsResponse(totalPrice, products);
	}


	private record PriceInfo(String categoryName, String brandName, BigInteger price) {}
}
