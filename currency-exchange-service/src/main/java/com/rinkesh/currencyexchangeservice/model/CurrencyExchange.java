package com.rinkesh.currencyexchangeservice.model;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * @author RinkeshKM
 * @date 27-Dec-21
 */

@Entity
@Table(name = "currency_exchange")
public class CurrencyExchange
{
	@Id
	private Long id;

	@Column(name = "CurrencyFrom")
	private String from;

	@Column(name = "CurrencyTo")
	private String to;

	@Column(name = "ConversionMultiple")
	private BigDecimal conversionMultiple;

	@Transient
	private String environment;

	public CurrencyExchange(final Long id, final String from, final String to, final BigDecimal conversionMultiple, final String environment)
	{
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.environment = environment;
	}

	public CurrencyExchange()
	{
	}

	public Long getId()
	{
		return id;
	}

	public void setId(final Long id)
	{
		this.id = id;
	}

	public String getFrom()
	{
		return from;
	}

	public void setFrom(final String from)
	{
		this.from = from;
	}

	public String getTo()
	{
		return to;
	}

	public void setTo(final String to)
	{
		this.to = to;
	}

	public BigDecimal getConversionMultiple()
	{
		return conversionMultiple;
	}

	public void setConversionMultiple(final BigDecimal conversionMultiple)
	{
		this.conversionMultiple = conversionMultiple;
	}

	public String getEnvironment()
	{
		return environment;
	}

	public void setEnvironment(final String environment)
	{
		this.environment = environment;
	}
}
