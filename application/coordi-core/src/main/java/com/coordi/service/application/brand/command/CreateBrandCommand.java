package com.coordi.service.application.brand.command;

import com.coordi.service.domain.brand.Brand;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateBrandCommand {

	@Builder
	public CreateBrandCommand(String name, String modifiedBy) {
		this.name = name;
		this.modifiedBy = modifiedBy;
	}

	private String name;
	private String modifiedBy;

	public Brand toModel() {
		return Brand.builder()
					.name(name)
					.isActive(true)
					.modifiedBy(modifiedBy)
					.build();
	}
}
