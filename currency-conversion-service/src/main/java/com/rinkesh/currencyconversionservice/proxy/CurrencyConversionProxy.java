package com.rinkesh.currencyconversionservice.proxy;

import com.rinkesh.currencyconversionservice.model.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author RinkeshKM
 * @date 27-Dec-21
 */

@FeignClient(name = "currency-exchange", url = "localhost:8000")
@Component
public interface CurrencyConversionProxy
{

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	Optional<CurrencyConversion> currencyExchange(@PathVariable String from,
												  @PathVariable String to);
}
