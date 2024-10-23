package com.coordi.service.application.product.port.in;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coordi.service.application.brand.port.out.BrandRepository;
import com.coordi.service.application.category.port.out.CategoryRepository;
import com.coordi.service.application.common.exception.ErrorCode;
import com.coordi.service.application.product.command.CreateProductCommand;
import com.coordi.service.application.product.command.UpdateProductCommand;
import com.coordi.service.application.product.port.out.ProductRepository;
import com.coordi.service.domain.product.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class ProductService implements ProductUseCase {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final BrandRepository brandRepository;

	@Override
	public Product create(CreateProductCommand createCommand) {
		brandRepository.findById(createCommand.getBrandId()).ifPresent(brand -> {
			throw ErrorCode.NOT_FOUND_DATA.toException("브랜드");
		});
		categoryRepository.findById(createCommand.getCategoryId()).ifPresent(category -> {
			throw ErrorCode.NOT_FOUND_DATA.toException("카테고리");
		});
		return productRepository.create(createCommand.toModel());
	}

	@Override
	public Product update(UpdateProductCommand updateCommand) {
		brandRepository.findById(updateCommand.getBrandId()).ifPresent(brand -> {
			throw ErrorCode.NOT_FOUND_DATA.toException("브랜드");
		});
		categoryRepository.findById(updateCommand.getCategoryId()).ifPresent(category -> {
			throw ErrorCode.NOT_FOUND_DATA.toException("카테고리");
		});
		return productRepository.update(updateCommand.toModel());
	}

	@Override
	public void delete(Long productId, String userName) {
		productRepository.deleteById(productId, userName);
	}

	@Override
	public Optional<Product> findById(Long productId) {
		return productRepository.findById(productId);
	}
}
