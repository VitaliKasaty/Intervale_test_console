package com.vitalikasaty.intervale.test.library.service;

import java.util.List;

import com.vitalikasaty.intervale.test.library.bean.Product;

public interface ProductService {	
	List<Product> getProducts() throws ServiceException;
	Product getProduct(int numProduct) throws ServiceException;
	List<Product> findProductByType(String type) throws ServiceException;
	List<Product> findProductByTitle(String title) throws ServiceException;
	List<Product> findProductByYearPublishing(int year) throws ServiceException;
	List<Product> findProductByTheme(String theme) throws ServiceException;
}
