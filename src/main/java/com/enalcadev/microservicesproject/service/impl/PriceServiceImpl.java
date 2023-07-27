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
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceRepository priceRepository;


    private final ModelMapper modelMapper;

    public PriceServiceImpl() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public PriceDto getPrice(LocalDateTime dateTime, Integer product, Integer brand) {

        List<Price> prices = new ArrayList<>(priceRepository.findByProductIdAndBrandId(product, brand));

        // Filter by start and end date
        List<Price> filterPrices = new ArrayList<>(prices.stream()
                .filter(price -> dateTime.isBefore(price.getEndDate())
                        && dateTime.isAfter(price.getStartDate()))
                .toList());

        // Sort list by priority with Comparator
        filterPrices.sort((price1, price2) -> price2.getPriority() - price1.getPriority());

        // Get first element and mapping result
        Optional<PriceDto> priceDtoOptional = filterPrices.stream().findFirst().map(price -> this.modelMapper.map(price, PriceDto.class));

        return priceDtoOptional.orElse(null);
    }
}
