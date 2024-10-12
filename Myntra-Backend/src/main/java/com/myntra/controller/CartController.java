package com.myntra.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.model.Cart;
import com.myntra.model.CartEntity;
import com.myntra.model.Page;
//import com.myntra.model.MenTShirt;
import com.myntra.service.CartService;

@RestController
@RequestMapping("api/myntra/shoppingCart")
@CrossOrigin(origins = "http://localhost:4201")
public class CartController {
	@Autowired
	public CartService cartService;

	@GetMapping
	public CartEntity GetAll() {
		CartEntity response = new CartEntity();
		response.setCartViewList(cartService.GetAllData());
//		Page page = new Page();
//		page.setSize(cartService.GetAllData().size());
//		response.setPage(page);
		return response;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Cart AddProduct(@RequestBody Cart cart) {
		return cartService.addCart(cart);
	}

	@DeleteMapping(value = { "/delete/{id}" }, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable String id) {
		System.out.println("Delete");
		return cartService.deleteProduct(id);
	}
}
