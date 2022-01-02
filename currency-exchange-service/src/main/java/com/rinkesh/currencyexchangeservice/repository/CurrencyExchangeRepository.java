package com.rinkesh.currencyexchangeservice.repository;

import com.rinkesh.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * @author RinkeshKM
 * @date 27-Dec-21
 */

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>
{

	Optional<CurrencyExchange> findByFromAndTo(String from, String to);
}
