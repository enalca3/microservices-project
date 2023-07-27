package com.enalcadev.microservicesproject.service;

import com.enalcadev.microservicesproject.dto.PriceDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public interface PriceService {

    PriceDto getPrice(LocalDateTime date, Integer product, Integer brand);
}
