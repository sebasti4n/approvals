package com.approvals.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/api")
public class AuthController {

	
	@GetMapping("/user")
	public ResponseEntity<?> getUser(Authentication authentication) {
		System.out.println(authentication); 
	    return ResponseEntity.ok(authentication);
	}

}
