package com.coordi.service.api.adapter.recommendation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coordi.service.application.recommendation.port.in.ProductRecommendationUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/recommendations")
@RequiredArgsConstructor
class RecommendationController {

	private final ProductRecommendationUseCase productRecommendationService;

	/**
	 * 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회 API
	 */
	@GetMapping("/min-price-products/category")
	public ResponseEntity<CategoryMinPriceProductsResponse> retrieveMinPriceProductsByCategory() {
		return ResponseEntity.ok(
			CategoryMinPriceProductsResponse.from(productRecommendationService.findMinPriceProductsByCategory()));
	}

	/**
	 * 단일 브랜드로 모든 카테고리 상품을 구매할 때
	 * 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API
	 */
	@GetMapping("/min-price-products/single-brand")
	public ResponseEntity<BrandMinPriceProductsResponse> retrieveMinPriceProductsBySingleBrand() {
		return ResponseEntity.ok(
			BrandMinPriceProductsResponse.from(productRecommendationService.findMinPriceProductsBySingleBrand()));
	}

	/**
	 * 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API
	 * @param categoryName
	 */
	@GetMapping("/min-max-price-products")
	public ResponseEntity<MinMaxPriceProductResponse> retrieveMinMaxPriceProducts(@RequestParam("categoryName") String categoryName) {
		return ResponseEntity.ok(
			MinMaxPriceProductResponse.from(productRecommendationService.findMinMaxPriceProducts(categoryName))
		);
	}
}
