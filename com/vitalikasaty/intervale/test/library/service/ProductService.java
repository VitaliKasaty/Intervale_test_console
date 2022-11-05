package com.vitalikasaty.intervale.test.library.service;

import java.util.List;

import com.vitalikasaty.intervale.test.library.bean.Product;

public interface ProductService {
	
	List<Product> getProducts() throws ServiceException;
	Product getProduct(int numProduct) throws ServiceException;

}
