package com.rinkesh.currencyconversionservice.controller;

import com.rinkesh.currencyconversionservice.model.CurrencyConversion;
import com.rinkesh.currencyconversionservice.proxy.CurrencyConversionProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author RinkeshKM
 * @date 27-Dec-21
 */

@RestController
public class CurrencyConversionController
{

	@Autowired
	private CurrencyConversionProxy currencyConversionProxy;


	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getCurrencyConversion(@PathVariable String from, @PathVariable String to,
													@PathVariable BigDecimal quantity){

		Map<String, String> uriVariable = new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);

		ResponseEntity<CurrencyConversion> currencyExchangeResponse = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversion.class, uriVariable);

		CurrencyConversion currencyConversion = currencyExchangeResponse.getBody();

		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity,
				currencyConversion.getConversionMultiple(),
				quantity.multiply(currencyConversion.getConversionMultiple()),
				currencyConversion.getEnvironment());
	}

	/**
	 * @apiNote Calling api by spring feign by creating proxy interface
	 * @param from
	 * @param to
	 * @param quantity
	 * @return CurrencyConversion
	 */
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
													@PathVariable BigDecimal quantity){

		Map<String, String> uriVariable = new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);

		// ResponseEntity<CurrencyConversion> currencyExchangeResponse = new RestTemplate().getForEntity(
		// 		"http://localhost:8000/currency-exchange/from/{from}/to/{to}",
		// 		CurrencyConversion.class, uriVariable);

		Optional<CurrencyConversion> currencyConversionResponse = currencyConversionProxy.currencyExchange(from, to);
		CurrencyConversion currencyConversion = new CurrencyConversion();

		if (currencyConversionResponse.isPresent()){
			currencyConversion = currencyConversionResponse.get();
		}

		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity,
				currencyConversion.getConversionMultiple(),
				quantity.multiply(currencyConversion.getConversionMultiple()),
				currencyConversion.getEnvironment());
	}
}
