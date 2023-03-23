package com.quickTicket.restdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickTicket.restdata.model.BusRequest;
import com.quickTicket.restdata.model.BusResponse;
import com.quickTicket.restdata.repository.SearchDAOlmpl;


@RestController
@RequestMapping(value = "/user")
public class SearchController
{
	@Autowired
	SearchDAOlmpl searchDAOImpl;
	
	//@PostMapping(value = "\save")
	//public ResponseEntity<Void> busResponse(@RequestBody BusResponse busResponse)
	//{
		//System.out.println("getting the BusRequest");
		//return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	//}
	
	@GetMapping(value = "/buslist")
	public BusResponse getBusResonseDetailsByUser(@RequestBody BusRequest busRequest)
	{
		System.out.println("getBusResonseDetailsByUser");
		return searchDAOImpl.getBusResonseDetailsByUser(busRequest);
	}
}
