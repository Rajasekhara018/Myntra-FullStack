package com.myntra.service;

import java.util.List;
import java.util.Map;

public interface PaymentGatewayService {

	public String generatePaymentOutputHtmlString();
	
	public String makePayment();

	public String extractKeyIndex();
}
