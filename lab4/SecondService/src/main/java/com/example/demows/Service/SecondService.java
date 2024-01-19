package com.example.demows.Service;

import com.example.demows.DTO.CountExpelledDTO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://service.ws.sample/", name = "SecondService")
public interface SecondService {



	@WebResult(name = "return", targetNamespace = "")
	@RequestWrapper(
			localName = "ping",
			targetNamespace = "http://service.ws.sample/",
			className = "sample.ws.service.RequestPing")
	@WebMethod(action = "urn:Ping")
	@ResponseWrapper(
			localName = "pingResponse",
			targetNamespace = "http://service.ws.sample/",
			className = "sample.ws.service.PingResponse")
	String ping();

	@WebResult(name = "return", targetNamespace = "")
	@RequestWrapper(
			localName = "countExpelledAllTime",
			targetNamespace = "http://service.ws.sample/",
			className = "sample.ws.service.RequestCountExpelledAllTime")
	@WebMethod(action = "urn:CountExpelledAllTime")
	@ResponseWrapper(
			localName = "countExpelledAllTimeResponse",
			targetNamespace = "http://service.ws.sample/",
			className = "sample.ws.service.CountExpelledAllTimeResponse")
	CountExpelledDTO countExpelledAllTime();


	@WebResult(name = "return", targetNamespace = "")
	@RequestWrapper(
			localName = "expelAllStudentsInGroup",
			targetNamespace = "http://service.ws.sample/",
			className = "sample.ws.service.RequestExpelAllStudentsInGroup")
	@WebMethod(action = "urn:ExpelAllStudentsInGroup")
	@ResponseWrapper(
			localName = "expelAllStudentsInGroupResponse",
			targetNamespace = "http://service.ws.sample/",
			className = "sample.ws.service.expelAllStudentsInGroupResponse")
	CountExpelledDTO expelAllStudentsInGroup(@WebParam(name = "id", targetNamespace = "") Long id);

}
