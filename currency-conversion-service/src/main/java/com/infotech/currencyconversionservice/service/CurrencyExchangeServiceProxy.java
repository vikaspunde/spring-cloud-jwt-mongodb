package com.infotech.currencyconversionservice.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.infotech.currencyconversionservice.model.CurrencyConversionModel;



//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

//	@GetMapping("/currency-exhange/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exhange/{from}/to/{to}")
	public CurrencyConversionModel retriveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) ;
		
	
}
