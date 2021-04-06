package net.polaris.Oauth2_Demo.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.polaris.Oauth2_Demo.dto.SignUpDto;
import net.polaris.Oauth2_Demo.payload.ApiResponse;
import net.polaris.Oauth2_Demo.service.AuthService;





@RestController
@RequestMapping("/auth")
public class AuthController {
		
	@Autowired
	private AuthService authService;
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/signup")
	public ApiResponse createUserAccount(@Valid @RequestBody SignUpDto signUpDto){
		
		return authService.registerUser(signUpDto);
	}
	
	
}
