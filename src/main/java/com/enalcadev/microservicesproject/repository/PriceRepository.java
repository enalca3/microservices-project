package com.enalcadev.microservicesproject.repository;

import com.enalcadev.microservicesproject.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findByProductIdAndBrandId(Integer product, Integer brand);
}
