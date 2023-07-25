package com.enalcadev.microservicesproject.service;

import com.enalcadev.microservicesproject.dto.PriceDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface PriceService {

    List<PriceDto> getPrices(LocalDate date, Integer product, Integer brand);
}
