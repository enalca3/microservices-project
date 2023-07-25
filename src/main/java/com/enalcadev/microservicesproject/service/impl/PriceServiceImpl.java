package com.enalcadev.microservicesproject.service.impl;

import com.enalcadev.microservicesproject.dto.PriceDto;
import com.enalcadev.microservicesproject.model.Price;
import com.enalcadev.microservicesproject.repository.PriceRepository;
import com.enalcadev.microservicesproject.service.PriceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceRepository priceRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<PriceDto> getPrices(LocalDate date, Integer product, Integer brand) {
        List<Price> prices = new ArrayList<>();

        priceRepository.findByDateProductBrand(date, product, brand).forEach(prices::add);
        // Mapping result
        return prices.stream().map(price -> modelMapper.map(price, PriceDto.class))
                .collect(Collectors.toList());
    }
}
