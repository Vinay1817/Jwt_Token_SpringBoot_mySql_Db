package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.DTO.UserSignUpDTO;
import com.task.message.APIResponse;
import com.task.model.User;
import com.task.repository.SignUpRepository;
import com.task.service.SignuUpService;
import com.task.utility.JWTUtility;


@RestController
public class SignUpController {
	
	@Autowired
	SignUpRepository repo;
	
	@Autowired
	 SignuUpService signuUpService;
	
	@Autowired
	JWTUtility jwtUtility;
	
	@PostMapping("/signup")
	public ResponseEntity<APIResponse> signUpForUser(@RequestBody UserSignUpDTO userSignUpDTO) {
		
		APIResponse apiResponse=signuUpService.signUp(userSignUpDTO);
		
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<APIResponse> logForUser(@RequestBody User users) {
	
		APIResponse apiResponse=new APIResponse();
		
	String tempEmail=users.getEmail();
		String tempass=users.getPassword();
		User userObj=null;
		
		if(tempEmail!=null && tempass!=null ) {
		 userObj=repo.findByEmailIgnoreCaseAndPassword(tempEmail, tempass);
//		 System.out.println("User "+userObj.getName());	
		}
		if(userObj==null) {
			apiResponse.setData("Invalid Credentials");
		
//			throw new Exception("Bad credentials");
//		}
//		String token=jwtUtility.generateJwt(userObj);
//		apiResponse.setData(token);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}
		else {
			String token=jwtUtility.generateJwt(userObj);
			apiResponse.setData(token);
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
			
		}
		
	}

}
