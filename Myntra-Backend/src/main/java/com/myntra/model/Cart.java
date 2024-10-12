package com.myntra.model;



import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value="Myntra-Cart")
@Data
public class Cart {

	private String id;
//  private String email;
	private String username;
//	private ShoppingCart shoppingCart;
//	private List<ShoppingCart> shoppingCart;
    private Object image; // You might want to change the type based on your requirements
    private double price;
    private int qty;
    private String name;
    private String orderId;
    private String brand;
    private String size;
	private List<Cart> cartViewList;
}
