package com.infotech.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infotech.currencyconversionservice.model.CurrencyConversionModel;
import com.infotech.currencyconversionservice.service.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("/currency-conversion/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionModel retriveCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		CurrencyConversionModel model= proxy.retriveExchangeValue(from, to);
		
		return new CurrencyConversionModel(model.getId(), from, to, 
				model.getConversionMultiple(), quantity, quantity.multiply(model.getConversionMultiple()), model.getPort());
	}
}
