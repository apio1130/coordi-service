package com.coordi.service.api.adapter.recommendation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.coordi.service.domain.recommendation.RecommendationProduct;

import lombok.Getter;

@Getter
class BrandMinPriceProductsResponse {

	BrandMinPriceProductsResponse(MinPriceInfo minPrice) {
		this.minPrice = minPrice;
	}

	private MinPriceInfo minPrice;

	public static BrandMinPriceProductsResponse from(List<RecommendationProduct> minPriceProductsByBrand) {
		BigInteger totalPrice = BigInteger.ZERO;
		List<PriceInfo> products = new ArrayList<>();
		for (RecommendationProduct product : minPriceProductsByBrand) {
			products.add(new PriceInfo(product.getCategoryName(), product.getPrice()));
			totalPrice = totalPrice.add(product.getPrice());
		}
		String brandName = "";
		if (!minPriceProductsByBrand.isEmpty()) {
			brandName = minPriceProductsByBrand.getFirst().getBrandName();
		}
		return new BrandMinPriceProductsResponse(new MinPriceInfo(brandName, products, totalPrice));
	}


	private record PriceInfo(String categoryName, BigInteger price) {}

	private record MinPriceInfo(String brand, List<PriceInfo> products, BigInteger totalPrice) {}
}
