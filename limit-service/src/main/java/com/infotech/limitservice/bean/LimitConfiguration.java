package com.infotech.limitservice.bean;

import org.springframework.stereotype.Component;

@Component
public class LimitConfiguration {

	private Integer minimum;
	private Integer maximum;
	
	
	public LimitConfiguration() {
		super();
	}
	public LimitConfiguration(Integer minimum, Integer maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}
	public Integer getMinimum() {
		return minimum;
	}
	public void setMinimum(Integer minimum) {
		this.minimum = minimum;
	}
	public Integer getMaximum() {
		return maximum;
	}
	public void setMaximum(Integer maximum) {
		this.maximum = maximum;
	}
	
	
}
