package com.enalcadev.microservicesproject.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PriceDto {
    private Integer productId;
    private Integer brandId;
    private Integer priceList;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private BigDecimal price;
    private String curr;
}
