package com.enalcadev.microservicesproject.repository;

import com.enalcadev.microservicesproject.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findByDateProductBrand(LocalDate date, Integer product, Integer brand);
}
