package com.rinkesh.currencyconversionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author RinkeshKM
 * @date 27-Dec-21
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversion
{
	private Long id;
	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal conversionMultiple;
	private BigDecimal totalCalculatedAmount;
	private String environment;

}
