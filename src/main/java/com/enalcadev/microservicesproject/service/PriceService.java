package com.enalcadev.microservicesproject.service;

import com.enalcadev.microservicesproject.dto.PriceDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface PriceService {

    List<PriceDto> getPrices(LocalDateTime date, Integer product, Integer brand);
}
