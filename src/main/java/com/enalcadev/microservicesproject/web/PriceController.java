package com.enalcadev.microservicesproject.web;

import com.enalcadev.microservicesproject.dto.PriceDto;
import com.enalcadev.microservicesproject.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")

public class PriceController {

    @Autowired
    PriceService priceService;

    @GetMapping("/price")
    public ResponseEntity<PriceDto> getPrice(
            @RequestParam() Integer product,
            @RequestParam() Integer brand,
            @RequestParam() LocalDateTime dateTime
            ) {

        try {
            PriceDto priceDto = priceService.getPrice(dateTime, product, brand);

            if (priceDto == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(priceDto, HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
