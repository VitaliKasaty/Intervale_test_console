package com.vitalikasaty.intervale.test.library.controller;

import java.util.List;

import com.vitalikasaty.intervale.test.library.bean.Product;

public interface LibraryController {
	List<Product> getProducts(String request);
	boolean addProduct(Product product);
	boolean editProduct(int numProduct, Product editedProduct);
	boolean deleteProduct(int numProduct);
}
