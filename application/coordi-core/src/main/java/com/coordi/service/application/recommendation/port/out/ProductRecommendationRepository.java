package com.coordi.service.application.recommendation.port.out;

import com.coordi.service.domain.recommendation.RecommendationProduct;

public interface ProductRecommendationRepository {

	RecommendationProduct findMinPriceByCategory(Long categoryId);
	RecommendationProduct findMaxPriceByCategory(Long categoryId);

	RecommendationProduct findMinPriceByBrand(Long brandId);

	Long findTopByMinTotalPriceBrand();
}
