package com.vitalikasaty.intervale.test.library.service;

import com.vitalikasaty.intervale.test.library.bean.Library;
import com.vitalikasaty.intervale.test.library.bean.Product;

public interface LibraryService {

	Library getLibrary() throws ServiceException;
	boolean saveLibrary(Library library) throws ServiceException;
	boolean addProduct(Product product) throws ServiceException;
	boolean editProdict(int numProduct, Product editedProduct) throws ServiceException;
	boolean deleteProduct(int numProduct) throws ServiceException;
}
