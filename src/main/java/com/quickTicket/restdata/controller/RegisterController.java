package com.quickTicket.restdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickTicket.restdata.model.User;
import com.quickTicket.restdata.repository.RegisterDAOImpl;

@RestController
public class RegisterController
{
	@Autowired
	RegisterDAOImpl registerdaoImpl;
	
	@PostMapping(value = "/register")
    public ResponseEntity<Void> saveUser(@RequestBody User user) {
		System.out.println("Save user details: user"+user);
		try 
		{
			registerdaoImpl.saveUserDetails(user);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
        	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
