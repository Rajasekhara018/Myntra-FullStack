package com.myntra.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
    private String id;
    private Object image; // You might want to change the type based on your requirements
    private double price;
    private int qty;
    private String name;
    private String orderId;
    private String brand;
    private String size;
}
