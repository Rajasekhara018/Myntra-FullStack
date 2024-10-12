package com.myntra.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myntra.model.Cart;
import com.myntra.repository.CartRepository;
import com.myntra.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public List<Cart> GetAllData() {
		// TODO Auto-generated method stub
		return cartRepository.findAll();
	}

	@Override
	public ResponseEntity<Map<String, String>> deleteProduct(String id) {
		cartRepository.deleteById(id);
		String responseMessage = " Product removed from Cart is Successfully";
		Map<String, String> jsonResponse = new HashMap<>();
		jsonResponse.put("message", responseMessage);
		System.out.println("Login Success");
		return ResponseEntity.ok().body(jsonResponse);
	}

	@Override
	public Cart addCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepository.save(cart);
	}

}
