package com.myntra.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

import com.myntra.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.myntra.constants.MyntraConstants;
import com.myntra.service.AuthService;

import javax.management.Query;

@RestController
@RequestMapping("flipkart")
@CrossOrigin(origins = "http://localhost:4201")
public class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	MongoOperations operationService;
//	@PostMapping(value = { "/register" }, consumes = { MediaType.APPLICATION_JSON_VALUE,
//			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
//	public AuthRegister registerUser(@RequestBody AuthRegister authRegister) {
//		return authService.registerUser(authRegister);
//	}

	@PostMapping(value = { "/login" }, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Map<String, String>> loginUser(@RequestBody AuthLogin authLogin) {
		return authService.loginUser(authLogin);
	}
//	JSONObject response = new JSONObject();
//	response.put(PPMSServiceConstants.SUCCESS, PPMSResponseMessagesConstants.ROLE_DELETED_SUCCESSFULLY);

	@PostMapping(value = { "/register" }, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AuthRegister> createUser(@RequestBody AuthRegister authRegister) {
		return new ResponseEntity<>(authService.registerUser(authRegister), HttpStatus.CREATED);
	}

	@PostMapping(value = { "/register/getall" }, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	    public ResponseObject getUsers(@RequestBody RequestObject req) {
		ResponseObject response = new ResponseObject();
		LinkedHashMap<String, String> reqObject = (LinkedHashMap) req.getObject();
		String firstName = reqObject.get("firstName");
		String lastName = reqObject.get("lastName");
		String userName = reqObject.get("userName");
		String email = reqObject.get("email");
		String gender= reqObject.get("gender");
		String dob= reqObject.get("dob");
		List<AuthRegister> registerDetails = null;
		if(firstName !=null || lastName !=null){
			Query query = new Query();

		} else {
			registerDetails = this.operationService.findAll(AuthRegister.class);
		}
		registerDetails.sort(Comparator.comparing(AuthRegister::getDob).reversed());
		if (req.getPageNo() != null && req.getPageSize() != null) {
			response = authService.convertPagination(req, registerDetails, response);
		}
		return response;
	}



}
