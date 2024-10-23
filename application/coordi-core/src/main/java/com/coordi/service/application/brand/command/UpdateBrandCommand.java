package com.coordi.service.application.brand.command;

import com.coordi.service.domain.brand.Brand;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateBrandCommand {

	@Builder
	public UpdateBrandCommand(Long id, String name, String modifiedBy) {
		this.id = id;
		this.name = name;
		this.modifiedBy = modifiedBy;
	}

	private Long id;
	private String name;
	private String modifiedBy;

	public Brand toModel() {
		return Brand.builder()
					.id(id)
					.name(name)
					.modifiedBy(modifiedBy)
					.build();
	}
}
