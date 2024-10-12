package com.myntra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.model.CartEntity;
import com.myntra.service.CartService;
import com.myntra.service.PaymentGatewayService;

@RestController
@RequestMapping("/paymentGateway")
@CrossOrigin(origins = "http://localhost:4201")
public class PaymentGatewayController {

	@Autowired
	public PaymentGatewayService paymentGatewayService;
	
	@GetMapping
	public String GetAll() {
		return paymentGatewayService.makePayment();
	}
}