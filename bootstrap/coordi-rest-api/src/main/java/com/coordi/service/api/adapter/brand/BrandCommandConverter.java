package com.coordi.service.api.adapter.brand;

import com.coordi.service.application.brand.command.CreateBrandCommand;
import com.coordi.service.application.brand.command.UpdateBrandCommand;

import lombok.experimental.UtilityClass;

@UtilityClass
class BrandCommandConverter {
	public static CreateBrandCommand toCreate(BrandRequest request) {
		return CreateBrandCommand.builder()
								 .name(request.name())
								 .modifiedBy(request.userName())
								 .build();
	}
	public static UpdateBrandCommand toUpdate(BrandRequest request, Long id) {
		return UpdateBrandCommand.builder()
								 .id(id)
								 .name(request.name())
								 .modifiedBy(request.userName())
								 .build();
	}
}
