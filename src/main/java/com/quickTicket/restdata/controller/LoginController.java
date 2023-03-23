package com.quickTicket.restdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.quickTicket.restdata.model.User;
import com.quickTicket.restdata.repository.LoginDAOImpl;

@Controller
public class LoginController 
{
	@Autowired
	LoginDAOImpl daoImpl;
	
	@PostMapping(value = "/login")
	public ResponseEntity<Void>  user(@RequestBody User user) {
		System.out.println("getting the login"+user);
		
//		Random randomGenerator = new Random();
//		int randomInt = randomGenerator.nextInt(8);
//		login.setId(randomInt);
	    
		if(0 ==user.getContactNo() || null == user.getPassword()) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
	    User savedUser = daoImpl.getUserLogin(user);
	    
	    if(null != savedUser && savedUser.getPassword().equals(user.getPassword())) {
	    	return new ResponseEntity<>(HttpStatus.OK);
	    }
	    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

}
