package com.coordi.service.domain.category;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Category {

	@Builder
	public Category(Long id, String name, boolean isActive, String modifiedBy) {
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
