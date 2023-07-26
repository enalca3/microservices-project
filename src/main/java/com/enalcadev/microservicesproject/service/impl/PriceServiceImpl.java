package com.enalcadev.microservicesproject.service.impl;

import com.enalcadev.microservicesproject.dto.PriceDto;
import com.enalcadev.microservicesproject.model.Price;
import com.enalcadev.microservicesproject.repository.PriceRepository;
import com.enalcadev.microservicesproject.service.PriceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceRepository priceRepository;


    private final ModelMapper modelMapper;

    public PriceServiceImpl() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<PriceDto> getPrices(LocalDateTime dateTime, Integer product, Integer brand) {
        List<Price> prices = new ArrayList<>();

        priceRepository.findByProductIdAndBrandId(product, brand).forEach(prices::add);
        // Mapping result
        return prices.stream().map(price -> this.modelMapper.map(price, PriceDto.class))
                .collect(Collectors.toList());
    }
}
