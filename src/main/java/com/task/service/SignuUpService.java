package com.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.DTO.UserSignUpDTO;
import com.task.message.APIResponse;
import com.task.model.User;
import com.task.repository.SignUpRepository;


@Service
public class SignuUpService {
	
	@Autowired
	SignUpRepository signUpRepository;
	
	

	public APIResponse signUp(UserSignUpDTO userSignUpDTO) {
		
		APIResponse apiResponse=new APIResponse();
		
		//apiResponse.setData("working fine!");
		
		//dto to model
		
		User user=new User();
		user.setName(userSignUpDTO.getName());
		user.setGender(userSignUpDTO.getGender());
		user.setEmail(userSignUpDTO.getEmail());
		user.setPhone(userSignUpDTO.getPhone());
		user.setPassword(userSignUpDTO.getPassword());
		
		//storing
		user=signUpRepository.save(user);
		
		//return
		apiResponse.setData(user);
		
		return apiResponse;
	}

//	public APIResponse login(UserLoginDTO userLoginDTO) {
//		
//		APIResponse apiResponse=new APIResponse();
//		
//		//verify user exist with given email and password
//		User user=signUpRepository.findByEmailIgnoreCaseAndPassword(userLoginDTO.getEmail(),userLoginDTO.getPassword());
//		
//	    
//		if(userLoginDTO.getEmail()!=null && userLoginDTO.getPassword()!=null) {
//		
//		if(user.getEmail().equals(userLoginDTO.getEmail()) && user.getPassword().equals(userLoginDTO.getPassword())) {
//			
//			
//			String token=jwtUtility.generateJwt(user);
//			apiResponse.setData(token);
//			apiResponse.setData("sucess");
//			System.out.println("Hello");
//
//			
//		}
//		}
//	    
//		//generate jwt
//	     
//		else {
//		
//
//		  System.out.println("fail");
//		}
//		apiResponse.setData("failed");
//
//		return apiResponse;
//		
//	}
	    
	}    
	

	    
		
		
	


