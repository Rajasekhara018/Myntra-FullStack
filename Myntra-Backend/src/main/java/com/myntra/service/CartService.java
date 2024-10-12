package com.myntra.service;

import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import com.myntra.model.Cart;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


public interface CartService {
	
	public List<Cart> GetAllData();
	
	public ResponseEntity<Map<String, String>> deleteProduct(String id);
	
	public Cart addCart(Cart cart);
	
	

//	@Autowired
//	private CartRepository cartRepository;
//
//	public List<Cart> GetAllData() {
//		return  cartRepository.findAll();
//	}
//
//	public Cart addCart(Cart cart) {
//		return cartRepository.save(cart);
//	}
//	
//	public ResponseEntity<Map<String, String>> deleteProduct(String id) {
//		cartRepository.deleteById(id);
//		String responseMessage = " Product removed from Cart is Successfully";
//		Map<String, String> jsonResponse = new HashMap<>();
//		jsonResponse.put("message", responseMessage);
//		System.out.println("Login Success");
//		return ResponseEntity.ok().body(jsonResponse);
//	}
//	@Autowired
//	private MongoTemplate mongotemplate;
//	Query deleteRoleQuery = new Query();
//	deleteRoleQuery.addCriteria(Criteria.where(PPMSServiceConstants.ROLE_ID).is(roleId));
//	mongoTemplate.remove(deleteRoleQuery, OrganizationRoles.class);
	
//	public Cart addCart(Cart cart) {
//		List<Cart> isProductPresent = cartRepository.findAll();
//		System.out.println("length" + isProductPresent.size());
//		if (isProductPresent.size() > 0) {
//			Criteria criteria = Criteria.where("age").gt(30);
//			Query query = new Query(criteria);
//			List<Cart> users = mongotemplate.find(query, Cart.class);
//			
//			return cartRepository.add(cart);
//		} else {
//			return cartRepository.save(cart);
//		}
//	}
	
//	public Object deleteProduct(String id) {
//		cartRepository.deleteById(id);
//		return id + "task deleted from dashboard";
//	}
}
