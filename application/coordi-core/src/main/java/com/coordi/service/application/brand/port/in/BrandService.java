package com.coordi.service.application.brand.port.in;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coordi.service.application.brand.command.CreateBrandCommand;
import com.coordi.service.application.brand.command.UpdateBrandCommand;
import com.coordi.service.application.brand.port.out.BrandRepository;
import com.coordi.service.domain.brand.Brand;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class BrandService implements BrandUseCase {

	private final BrandRepository brandRepository;

	@Override
	public Brand create(CreateBrandCommand createCommand) {
		return brandRepository.create(createCommand.toModel());
	}

	@Override
	public Brand update(UpdateBrandCommand updateCommand) {
		return brandRepository.update(updateCommand.toModel());
	}

	@Override
	public void delete(Long brandId, String userName) {
		brandRepository.deleteById(brandId, userName);
	}

	@Override
	public Optional<Brand> findById(Long brandId) {
		return brandRepository.findById(brandId);
	}

}
