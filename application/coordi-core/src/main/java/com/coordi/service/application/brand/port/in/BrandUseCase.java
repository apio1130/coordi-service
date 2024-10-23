package com.coordi.service.application.brand.port.in;

import java.util.Optional;

import com.coordi.service.application.brand.command.CreateBrandCommand;
import com.coordi.service.application.brand.command.UpdateBrandCommand;
import com.coordi.service.domain.brand.Brand;

public interface BrandUseCase {
	Brand create(CreateBrandCommand createCommand);
	Brand update(UpdateBrandCommand updateCommand);
	void delete(Long brandId, String userName);
	Optional<Brand> findById(Long brandId);
}
