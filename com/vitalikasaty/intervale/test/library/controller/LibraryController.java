package com.vitalikasaty.intervale.test.library.controller;

import com.vitalikasaty.intervale.test.library.bean.Product;

public interface LibraryController {
	boolean addProduct(Product product);
	boolean editProduct(int numProduct, Product editedProduct);
	boolean deleteProduct(int numProduct);
}
