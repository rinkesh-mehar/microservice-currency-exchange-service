package com.rinkesh.currencyexchangeservice.controller;

import com.rinkesh.currencyexchangeservice.model.CurrencyExchange;
import com.rinkesh.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


/**
 * @author RinkeshKM
 * @date 27-Dec-21
 */

@RestController
public class CurrencyController
{
	@Autowired
	Environment environment;

	@Autowired
	CurrencyExchangeRepository currencyExchangeRepository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public Optional<CurrencyExchange> currencyExchange(@PathVariable String from, @PathVariable String to){
		// return new CurrencyExchange( 1000L, from, to, BigDecimal.valueOf(50),
		// 		environment.getProperty("local.server.port"));

		Optional<CurrencyExchange> currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
		if (currencyExchange.isEmpty()){
			throw new RuntimeException("Data Not Found");
		}

		currencyExchange.get().setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
	}
}
