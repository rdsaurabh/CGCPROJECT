package com.common;

import java.util.ArrayList;

import com.models.Product;

public class Cart extends ArrayList<Product> {
	private static Cart obj;
	private Cart() {
	
	}
	
	public static Cart getInstance() {
		if(obj==null) {
			obj = new Cart();
		}
		return obj;
	}
	
	public double getTotal() {
		double total = 0;
		for(Product p : this) {
			total+=p.getTotal();
		}
		return total;
	}
}
