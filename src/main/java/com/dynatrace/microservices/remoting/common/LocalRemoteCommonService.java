package com.dynatrace.microservices.remoting.common;

import org.springframework.web.client.RestClientException;

import com.dynatrace.microservices.remoting.ExceptionHandler;
import com.dynatrace.microservices.rest.common.Status;

public class LocalRemoteCommonService implements CommonService {

	private final RemoteCommonService service;
	private final ExceptionHandler exceptionHandler;
	
	public LocalRemoteCommonService(RemoteCommonService service, ExceptionHandler exceptionHandler) {
		this.service = service;
		this.exceptionHandler = exceptionHandler;
	}
	
	@Override
	public boolean shutdown() {
		try {
			return service.shutdown();
		} catch (RestClientException e) {
			exceptionHandler.handle(e);
			return false;
		}
	}

	@Override
	public String ping() {
		return null;
	}

	@Override
	public Status getStatus() {
		return null;
	}
	
	@Override
	public String getQuote() {
		try {
			return service.getQuote();
		} catch (RestClientException e) {
			exceptionHandler.handle(e);
			return Boolean.FALSE.toString();
		}
	}
	
}
