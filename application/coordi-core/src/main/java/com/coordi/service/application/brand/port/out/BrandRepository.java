package com.coordi.service.application.brand.port.out;

import java.util.Optional;

import com.coordi.service.domain.brand.Brand;

public interface BrandRepository {

	Brand create(Brand brand);

	Brand update(Brand brand);

	Optional<Brand> findById(Long id);

	void deleteById(Long id, String userName);
}
