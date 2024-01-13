package com.example.demows;

import javax.xml.ws.Endpoint;

import com.example.demows.Service.Impl.SecondServiceImpl;
import org.apache.cxf.Bus;

import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WSConfig {
	@Autowired
	SecondServiceImpl secondService;
	
	@Autowired
	private Bus bus;
	
	@Bean
	public Endpoint helloEndpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, secondService);
		endpoint.publish("/SecondService");
		
		return endpoint;
	}
}
