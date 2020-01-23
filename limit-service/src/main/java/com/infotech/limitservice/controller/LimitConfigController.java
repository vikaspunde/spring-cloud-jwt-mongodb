package com.infotech.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotech.limitservice.bean.LimitConfiguration;
import com.infotech.limitservice.model.ConfigurationModel;

@RestController
public class LimitConfigController {

	@Autowired
	private ConfigurationModel configurationModel;
	
	@RequestMapping("/limit")
	public LimitConfiguration retriveConfiguration() {
		return new LimitConfiguration(configurationModel.getMinimum(), configurationModel.getMaximum());
	}
}
