package com.coordi.service.storage.adapter.product;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coordi.service.application.common.exception.ErrorCode;
import com.coordi.service.application.product.port.out.ProductRepository;
import com.coordi.service.domain.product.Product;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

	private final ProductJpaRepository jpaRepository;

	@Override
	@Transactional
	public Product create(Product product) {
		ProductEntity productEntity = jpaRepository.save(ProductDataConverter.toCreateEntity(product));
		return ProductDataConverter.toModel(productEntity);
	}

	@Override
	@Transactional
	public Product update(Product product) {
		var originEntity = jpaRepository.findById(product.getId())
										.orElseThrow(() -> ErrorCode.NOT_FOUND_DATA.toException("상품"));
		ProductEntity productEntity = jpaRepository.save(ProductDataConverter.toUpdateEntity(originEntity, product));
		return ProductDataConverter.toModel(productEntity);
	}

	@Override
	public Optional<Product> findById(Long id) {
		return jpaRepository.findById(id).map(ProductDataConverter::toModel);
	}

	@Override
	@Transactional
	public void deleteById(Long id, String userName) {
		jpaRepository.deleteById(id, userName);
	}
}
