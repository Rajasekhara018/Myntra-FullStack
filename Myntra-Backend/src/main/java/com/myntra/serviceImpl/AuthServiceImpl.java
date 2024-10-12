package com.myntra.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myntra.AESencryption.AESAlgorithm;
import com.myntra.constants.MyntraConstants;
import com.myntra.model.*;
import com.myntra.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myntra.repository.AuthRegistrationRepository;
import com.myntra.service.AuthService;
import org.springframework.data.domain.PageImpl;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthRegistrationRepository authRegisterRepository;

	@Autowired
	private AESAlgorithm aesAlgorithm;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private MailSenderService mailSenderService;

	@Override
	public ResponseEntity<Map<String, String>> loginUser(AuthLogin authLogin) {
		AuthLogin loggedInUser = authRegisterRepository.findByEmailAndPassword(authLogin.getEmail(), authLogin.getPassword());
		  
		if (loggedInUser != null) {
			String responseMessage = "Login Successful";
			Map<String, String> jsonResponse = new HashMap<>();
			jsonResponse.put("message", responseMessage);
			System.out.println("Login Success");
			return ResponseEntity.ok().body(jsonResponse);
		} else {
			String responseMessage = "Invalid credentials";
			Map<String, String> jsonResponse = new HashMap<>();
			jsonResponse.put("message", responseMessage);
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(jsonResponse);
		}
	}

	@Override
	public AuthRegister registerUser(AuthRegister authRegister) { 
		// TODO Auto-generated method stub
        try {
            String email= aesAlgorithm.decrypt(authRegister.getEmail(), MyntraConstants.SECRET_KEY);
			System.out.print(email);
			mailSenderService.RegistrationConfirmationWithPdf(authRegister);
			mailSenderService.RegistrationConfirmation(authRegister);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  authRegisterRepository.save(authRegister);
	}

	@Override
	public ResponseObject convertPagination(RequestObject req, List<AuthRegister> registerDetails, ResponseObject response) {
		int totalRecords = registerDetails.size();
		int totalPages = (int) Math.ceil((double) totalRecords / req.getPageSize());

		// Calculate the start and end indices for the sublist
		int startIndex = req.getPageNo() * req.getPageSize();
		int endIndex = Math.min(startIndex + req.getPageSize(), totalRecords);

		// Extract the sublist for the current page
		List<AuthRegister> sublist = new ArrayList<>();
		if (startIndex < endIndex) {
			sublist = registerDetails.subList(startIndex, endIndex);
		} else {
			sublist = registerDetails;
		}
		PageImpl<AuthRegister> pageImpl = reurnpagedata(sublist,
				PageRequest.of(req.getPageNo(), req.getPageSize()), totalRecords);
		response.setObject(pageImpl);
		return response;
	}

	@Override
	public List<AuthRegister> registerUserGetAll(UserSearchCriteria searchUsers) {
		return List.of();
	}

	private <AuthRegister> PageImpl<AuthRegister> reurnpagedata(List<AuthRegister> sublist, PageRequest of, int totalRecords) {
		return new PageImpl<>(sublist, of, totalRecords);
	}

//	ZoneId zoneId = ZoneId.of("Asia/Kolkata");
//	LocalDate fromDate = null;
//	LocalDate toDate = null;
//	LocalDateTime fromDateTime = null;
//	LocalDateTime toDateTime = null;
//		if (reqObject.get("txnfromDate") != null) {
//		fromDate = LocalDate.parse(reqObject.get("txnfromDate"));
//		fromDateTime = fromDate.atStartOfDay(zoneId).toLocalDateTime();
//	}
//		if (reqObject.get("txntoDate") != null) {
//		toDate = LocalDate.parse(reqObject.get("txntoDate"));
//		toDateTime = toDate.plusDays(1).atStartOfDay(zoneId).minusNanos(1).toLocalDateTime();
//	}
//	private PageImpl<AuthRegister> reurnpagedata(List<AuthRegister> sublist, PageRequest of,
//													  int totalRecords) {
//		return new PageImpl<>(sublist, of, totalRecords);
//	}

//	public List<AuthRegister> registerUserGetAll(UserSearchCriteria searchUsers) {
//		// TODO Auto-generated method stub
//		if(searchUsers.equals("null")){
//			Query query = new Query();
//			query.addCriteria(null);
//			return mongoTemplate.find(query, AuthRegister.class);
//		} else {
//			return authRegisterRepository.findAll();
//		}
//	}


}