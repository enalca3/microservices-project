package com.enalcadev.microservicesproject.service;

import com.enalcadev.microservicesproject.dto.PriceDto;

import java.time.LocalDate;
import java.util.List;

public interface PriceService {

    List<PriceDto> getPrices(LocalDate date, Integer product, Integer brand);
}
