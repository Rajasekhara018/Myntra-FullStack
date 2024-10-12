package com.myntra.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import com.myntra.constants.MyntraConstants;
import com.myntra.service.PaymentGatewayService;

import lombok.val;

@Service
public class PaymentGatewayServiceImpl implements PaymentGatewayService {

	@Value("${myntra.merchant.id}")
	private String merchantId;

	@Value("${myntra.merchant.encpwd}")
	private String encpwd;

	@Value("${myntra.merchant.terminal}")
	private String terminal;

	@Value("${myntra.merchant.currency}")
	private String currency;

	@Autowired
	private RestTemplate restTemplate;

	public String makePayment() {
//		log.info("In makePayment  -  Method Started ");
		String outputHtml = generatePaymentOutputHtmlString();
//		log.info("In makePayment  -  Method Ended ");
		return outputHtml.toString();
	}

	public String generatePaymentOutputHtmlString() {
		String keyIndex = this.extractKeyIndex();
		String token = this.extractToken(keyIndex);
		String orderId = System.currentTimeMillis() + "";
		System.out.println("llllllllllllll " + orderId);

		System.out.println("llllllllllllll token" + token);
		setStoreOrderId(orderId);
		JSONObject jo = new JSONObject();
		jo.put("token", token);
		jo.put("order", orderId);
		jo.put("terminal", this.terminal);
		jo.put("currency", this.currency);
		return jo.toString();
	}

	@Override
	public String extractKeyIndex() {
		// TODO Auto-generated method stub
		HttpEntity<String> httpEntity = new HttpEntity<String>(MyntraConstants.DUMMY_JSON_FOR_PRETOKEN,
				gethttpHeaders());
		try {
//			val response = restTemplate.exchange(MyntraConstants.PRETOKEN_URL, HttpMethod.POST, httpEntity, List.class);
//			JSONObject joPreAuth = new JSONObject(response);
//			return joPreAuth.getJSONObject("object").getString("key_index");
		} catch (Exception e) {

		}
		return null;
	}

	private HttpHeaders gethttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}


	public String extractToken(String keyIndex) {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject jo = new JSONObject();
		jo.put("id", merchantId);
		jo.put("encryptedPassword", encpwd);
		jo.put("keyIndex", keyIndex);
		HttpEntity<String> entity = new HttpEntity<>(jo.toString(), headers);
		try {
			String data = restTemplate.postForObject(MyntraConstants.TOKEN_URL, entity, String.class);
			JSONObject joToken = new JSONObject(data);
			String extractedToken = joToken.getString("token");
			System.out.println("extract Token" + extractedToken);
			return extractedToken;
		} catch (Exception e) {

		}

		return null;
	}

	private String storeOrderId;

	public void setStoreOrderId(String id) {
		this.storeOrderId = id;
	}

	public String getStoreOrderId() {
		return storeOrderId;
	}

}
