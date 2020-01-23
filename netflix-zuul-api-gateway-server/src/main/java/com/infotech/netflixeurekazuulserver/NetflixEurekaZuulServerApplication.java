package com.infotech.netflixeurekazuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

import brave.sampler.Sampler;
@EnableZuulServer
@EnableDiscoveryClient
@SpringBootApplication
public class NetflixEurekaZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixEurekaZuulServerApplication.class, args);
	}
	
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
