package com.example.demows.Service.Impl;

import com.example.demows.DTO.CountExpelledDTO;
import com.example.demows.Service.SecondService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@WebService(
		serviceName = "SecondService",
		portName = "HelloPort",
		targetNamespace = "http://service.ws.sample/",
		endpointInterface = "com.example.demows.Service.SecondService")
@Component
@AllArgsConstructor
public class SecondServiceImpl implements SecondService {

	private final ProductServiceImpl productService;
	@Override
	public String ping() {
		return "pong";
	}

	@Override
	public CountExpelledDTO countExpelledAllTime() {
		return productService.getCountExpelledStudent();
	}

	@Override
	public CountExpelledDTO expelAllStudentsInGroup(Long id) {
		return productService.expelAllStudentsInGroup(id);

	}

}
