package com.myntra.service;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myntra.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myntra.repository.AuthRegistrationRepository;


//@Service
public interface AuthService {
	
	public ResponseEntity<Map<String, String>> loginUser(AuthLogin authLogin);
	
	public AuthRegister registerUser(AuthRegister authRegister);

	ResponseObject convertPagination(RequestObject req, List<AuthRegister> disputes, ResponseObject response);

	public List<AuthRegister> registerUserGetAll(UserSearchCriteria searchUsers);


//	@Autowired
//	private AuthRegistrationRepository authRegisterRepository;
//	public AuthRegister registerUser(AuthRegister authRegister) {
//		
//		return authRegisterRepository.save(authRegister);
//	}
//	public ResponseEntity<Map<String, String>> loginUser(AuthLogin authLogin) {
//		
//		AuthLogin loggedInUser = authRegisterRepository.findByEmailAndPassword(authLogin.getEmail(), authLogin.getPassword());
//		  
//		if (loggedInUser != null) {
//			String responseMessage = "Login Successful";
//			Map<String, String> jsonResponse = new HashMap<>();
//			jsonResponse.put("message", responseMessage);
//			System.out.println("Login Success");
//			return ResponseEntity.ok().body(jsonResponse);
//		} else {
//			String responseMessage = "Invalid credentials";
//			Map<String, String> jsonResponse = new HashMap<>();
//			jsonResponse.put("message", responseMessage);
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(jsonResponse);
//		}
//	}

}
