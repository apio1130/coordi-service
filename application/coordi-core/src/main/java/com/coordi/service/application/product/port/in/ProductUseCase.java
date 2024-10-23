package com.coordi.service.application.product.port.in;

import java.util.Optional;

import com.coordi.service.application.product.command.CreateProductCommand;
import com.coordi.service.application.product.command.UpdateProductCommand;
import com.coordi.service.domain.product.Product;

public interface ProductUseCase {
	Product create(CreateProductCommand createCommand);
	Product update(UpdateProductCommand updateCommand);
	void delete(Long productId, String userName);
	Optional<Product> findById(Long productId);
}
