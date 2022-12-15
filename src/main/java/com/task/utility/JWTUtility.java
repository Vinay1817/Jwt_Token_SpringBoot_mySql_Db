package com.task.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.task.model.User;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtility {
	
	private  String secret="This_Is_Secrete_Key";
	
	public String generateJwt(User user) {
		
		//java inbuild class
		DateTimeFormatter dft=DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		String current=dft.format(now);
		//System.out.println("current date"+dft.format(now));
		
//		Date issuedAt=new Date();
//		
//		//calims
//		Claims claims=Jwts.claims()
//				.setIssuer(user.getEmail().toString())
//				.setIssuedAt(issuedAt);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("cureent date", current);
		map.put("id",user.getId());
		map.put("email",user.getEmail());
		map.put("name",user.getName());
		map.put("gender",user.getGender());
		String s=Jwts.builder()
				.setClaims(map)
				.signWith(SignatureAlgorithm.HS512,secret)
				.compact();
		//System.out.println("The Result is"+s);
		return s;
		
	}

}
