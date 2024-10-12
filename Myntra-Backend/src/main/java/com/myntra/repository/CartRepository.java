package com.myntra.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myntra.model.Cart;
import com.myntra.model.MenTShirt;
import com.myntra.model.ShoppingCart;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

//	Cart findByShoppingCart(List<ShoppingCart> shoppingCart);
	
//	MyntraCart findByShoppingCartAndEmail(List<MyntraShoppingCart> shoppingCart, String email);

//	MyntraCart findByEmail(String email);
	
//	Cart findByUsername(String userName);
	

//	List<MyntraCart> findbyCartData(List<MyntraShoppingCart> shoppingCart);
}
