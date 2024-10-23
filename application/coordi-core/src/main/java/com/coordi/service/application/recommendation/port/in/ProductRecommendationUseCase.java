package com.coordi.service.application.recommendation.port.in;

import java.util.List;

import com.coordi.service.domain.recommendation.MinMaxPriceProducts;
import com.coordi.service.domain.recommendation.RecommendationProduct;

public interface ProductRecommendationUseCase {

	List<RecommendationProduct> findMinPriceProductsByCategory();

	List<RecommendationProduct> findMaxPriceProductsByCategory();

	RecommendationProduct findMinPriceProductByCategory(String categoryName);

	RecommendationProduct findMaxPriceProductByCategory(String categoryName);

	List<RecommendationProduct> findMinPriceProductsBySingleBrand();

	MinMaxPriceProducts findMinMaxPriceProducts(String categoryName);
}
