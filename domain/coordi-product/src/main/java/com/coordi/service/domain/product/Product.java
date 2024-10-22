package com.coordi.service.domain.product;

import java.math.BigInteger;

public record Product(Long id, BigInteger price, Long categoryId, Long brandId, boolean isActive) {
}
