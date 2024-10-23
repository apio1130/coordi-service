package com.coordi.service.domain.brand;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Brand {

	@Builder
	public Brand(Long id, String name, boolean isActive, String modifiedBy) {
		this.id = id;
		this.name = name;
		this.isActive = isActive;
		this.modifiedBy = modifiedBy;
	}

	private Long id;
	private String name;
	private boolean isActive;
	private String modifiedBy;
}
