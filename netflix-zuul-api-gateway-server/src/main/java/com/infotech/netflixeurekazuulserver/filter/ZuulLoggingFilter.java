package com.infotech.netflixeurekazuulserver.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{
	
	private Logger logger = LoggerFactory.getLogger(ZuulLoggingFilter.class);
	
	//should this filter execute?
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	//bussiness logic
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request= RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {}, request uri -> {}", request, request.getRequestURI());
		
		return null;
	}

	//type of filter means should execute before(pre), after(post) request or error(error)
	@Override
	public String filterType() {
		return "pre";
	}
	//order of filter , at which order filter has to be executed
	@Override
	public int filterOrder() {
		return 1;
	}

}
