package com.vitalikasaty.intervale.test.library.service.impl;

import com.vitalikasaty.intervale.test.library.bean.Library;
import com.vitalikasaty.intervale.test.library.bean.Product;
import com.vitalikasaty.intervale.test.library.service.LibraryService;
import com.vitalikasaty.intervale.test.library.service.ServiceException;

public class LibraryServiceControllerImpl implements LibraryService{

	@Override
	public Library getLibrary() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveLibrary(Library library) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addProduct(Product product) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editProdict(int numProduct, Product editedProduct) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(int numProduct) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}
