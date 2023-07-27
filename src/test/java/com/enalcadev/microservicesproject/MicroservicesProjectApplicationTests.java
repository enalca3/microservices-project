package com.enalcadev.microservicesproject;

import com.enalcadev.microservicesproject.dto.PriceDto;
import com.enalcadev.microservicesproject.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MicroservicesProjectApplication.class)
class MicroservicesProjectApplicationTests {

	@Autowired
	private PriceService priceService;

	/***
	 * Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 */
	@Test
	void getPrice1() {

		Integer brandId = 1;
		Integer productId = 35455;
		LocalDateTime dateTime = LocalDateTime.parse("2020-06-14T10:00:00");

		PriceDto price = new PriceDto();
		price.setPrice(BigDecimal.valueOf(35.5));
		price.setPriceList(1);
		price.setCurr("EUR");
		price.setBrandId(1);
		price.setStartDate(LocalDateTime.parse("2020-06-14T00:00:00"));
		price.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));
		price.setProductId(35455);

		PriceDto priceResult = this.priceService.getPrice(dateTime,productId,brandId);

		assertNotNull(priceResult);
		assertEquals(price.getPriceList(), priceResult.getPriceList());

	}

	/**
	 * Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 */
	@Test
	void getPrice2() {

		Integer brandId = 1;
		Integer productId = 35455;
		LocalDateTime dateTime = LocalDateTime.parse("2020-06-14T16:00:00");

		PriceDto price = new PriceDto();
		price.setPrice(BigDecimal.valueOf(25.45));
		price.setPriceList(2);
		price.setCurr("EUR");
		price.setBrandId(1);
		price.setStartDate(LocalDateTime.parse("2020-06-14T15:00:00"));
		price.setEndDate(LocalDateTime.parse("2020-06-14T18:00:00"));
		price.setProductId(35455);

		PriceDto priceResult = this.priceService.getPrice(dateTime,productId,brandId);

		assertNotNull(priceResult);
		assertEquals(price.getPriceList(), priceResult.getPriceList());

	}

	/***
	 * Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 */
	@Test
	void getPrice3() {

		Integer brandId = 1;
		Integer productId = 35455;
		LocalDateTime dateTime = LocalDateTime.parse("2020-06-14T21:00:00");

		PriceDto price = new PriceDto();
		price.setPrice(BigDecimal.valueOf(35.5));
		price.setPriceList(1);
		price.setCurr("EUR");
		price.setBrandId(1);
		price.setStartDate(LocalDateTime.parse("2020-06-14T00:00:00"));
		price.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));
		price.setProductId(35455);

		PriceDto priceResult = this.priceService.getPrice(dateTime,productId,brandId);

		assertNotNull(priceResult);
		assertEquals(price.getPriceList(), priceResult.getPriceList());

	}

	/***
	 * Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
	 */
	@Test
	void getPrice4() {

		Integer brandId = 1;
		Integer productId = 35455;
		LocalDateTime dateTime = LocalDateTime.parse("2020-06-15T10:00:00");

		PriceDto price = new PriceDto();
		price.setPrice(BigDecimal.valueOf(30.5));
		price.setPriceList(3);
		price.setCurr("EUR");
		price.setBrandId(1);
		price.setStartDate(LocalDateTime.parse("2020-06-15T00:00:00"));
		price.setEndDate(LocalDateTime.parse("2020-06-15T11:00:00"));
		price.setProductId(35455);

		PriceDto priceResult = this.priceService.getPrice(dateTime,productId,brandId);

		assertNotNull(priceResult);
		assertEquals(price.getPriceList(), priceResult.getPriceList());

	}

	/***
	 * Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
	 */
	@Test
	void getPrice5() {

		Integer brandId = 1;
		Integer productId = 35455;
		LocalDateTime dateTime = LocalDateTime.parse("2020-06-15T21:00:00");

		PriceDto price = new PriceDto();
		price.setPrice(BigDecimal.valueOf(38.95));
		price.setPriceList(4);
		price.setCurr("EUR");
		price.setBrandId(1);
		price.setStartDate(LocalDateTime.parse("2020-06-15T16:00:00"));
		price.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));
		price.setProductId(35455);

		PriceDto priceResult = this.priceService.getPrice(dateTime,productId,brandId);

		assertNotNull(priceResult);
		assertEquals(price.getPriceList(), priceResult.getPriceList());

	}

	/***
	 * Test NULL: petición a las 21:00 del día 15 del producto 1   para la brand 1 (ZARA)
	 */
	@Test
	void getPriceNull() {

		Integer brandId = 1;
		Integer productId = 1;
		LocalDateTime dateTime = LocalDateTime.parse("2020-06-15T21:00:00");

		PriceDto priceResult = this.priceService.getPrice(dateTime,productId,brandId);

		assertNull(priceResult);

	}
}
