package com.coordi.service.application.product.port.out;

import java.util.Optional;

import com.coordi.service.domain.product.Product;

public interface ProductRepository {

	Product create(Product product);

	Product update(Product product);

	Optional<Product> findById(Long id);

	void deleteById(Long id, String userName);
}
