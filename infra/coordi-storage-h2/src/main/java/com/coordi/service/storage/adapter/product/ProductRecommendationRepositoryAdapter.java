package com.coordi.service.storage.adapter.product;

import org.springframework.stereotype.Repository;

import com.coordi.service.application.common.exception.ErrorCode;
import com.coordi.service.application.recommendation.port.out.ProductRecommendationRepository;
import com.coordi.service.domain.recommendation.RecommendationProduct;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductRecommendationRepositoryAdapter implements ProductRecommendationRepository {

	private final ProductRecommendationJpaRepository jpaRepository;

	@Override
	public RecommendationProduct findMinPriceByCategory(Long categoryId) {
		return RecommendationProductConverter.toModel(jpaRepository.findMinPriceByCategory(categoryId)
											 .orElseThrow(() -> ErrorCode.NOT_FOUND_DATA.toException("카테고리 상품")));
	}

	@Override
	public RecommendationProduct findMaxPriceByCategory(Long categoryId) {
		return RecommendationProductConverter.toModel(jpaRepository.findMaxPriceByCategory(categoryId)
											 .orElseThrow(() -> ErrorCode.NOT_FOUND_DATA.toException("카테고리 상품")));
	}

	@Override
	public RecommendationProduct findMinPriceByBrand(Long brandId) {
		return RecommendationProductConverter.toModel(jpaRepository.findMinPriceByBrand(brandId)
						    				 .orElseThrow(() -> ErrorCode.NOT_FOUND_DATA.toException("브랜드 상품")));
	}

	@Override
	public Long findTopByMinTotalPriceBrand() {
		return jpaRepository.findTopByMinTotalPriceBrand()
							.orElseThrow(() -> ErrorCode.NOT_FOUND_DATA.toException("상품"))
							.getBrandId();
	}
}
