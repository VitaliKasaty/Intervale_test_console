package com.vitalikasaty.intervale.test.library.presentation;

import java.util.List;

import com.vitalikasaty.intervale.test.library.bean.Product;

public class PrintProduct {
	
	public void printProducts (List<Product> products) {
		for (int i = 0; i < products.size(); i++) {
			System.out.println((i + 1) + ") " + products.get(i));
		}
		System.out.println();
	}
	

}
