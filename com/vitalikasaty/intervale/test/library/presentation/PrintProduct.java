package com.vitalikasaty.intervale.test.library.presentation;

import java.util.List;

import com.vitalikasaty.intervale.test.library.bean.Product;

public class PrintProduct {

	public void printProducts(List<Product> products) {
		for (int i = 0; i < products.size(); i++) {
			System.out.println((i + 1) + ") " + products.get(i));
		}
		System.out.println();
	}

	public void readProduct(List<Product> products, int numToRead) {
		System.out.println(products.get(numToRead - 1));
		System.out.println("Текст:");
		System.out.println(products.get(numToRead - 1).getText() + "\n");
	}

}
