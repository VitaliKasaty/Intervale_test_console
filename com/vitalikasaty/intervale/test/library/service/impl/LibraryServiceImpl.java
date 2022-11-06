package com.vitalikasaty.intervale.test.library.service.impl;

import com.vitalikasaty.intervale.test.library.bean.Library;
import com.vitalikasaty.intervale.test.library.bean.Product;
import com.vitalikasaty.intervale.test.library.dao.DAOException;
import com.vitalikasaty.intervale.test.library.dao.DAOProvider;
import com.vitalikasaty.intervale.test.library.dao.LibraryDAO;
import com.vitalikasaty.intervale.test.library.service.LibraryService;
import com.vitalikasaty.intervale.test.library.service.ServiceException;

public class LibraryServiceImpl implements LibraryService{

	private final DAOProvider provider = DAOProvider.getInstance();
	
	@Override
	public Library getLibrary() throws ServiceException {
		LibraryDAO libraryDAO = provider.getLibraryDAO();
		try {
			return libraryDAO.getLibrary();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public boolean saveLibrary(Library library) throws ServiceException {
		LibraryDAO libraryDAO = provider.getLibraryDAO();
		try {
			return libraryDAO.saveLibrary(library);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}		
	}

	@Override
	public boolean addProduct(Product product) throws ServiceException {
		LibraryDAO libraryDAO = provider.getLibraryDAO();
		Library library;
		try {
			library = libraryDAO.getLibrary();
			library.addProduct(product);
			return libraryDAO.saveLibrary(library);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}		
	}

	@Override
	public boolean editProdict(int numProduct, Product editedProduct) throws ServiceException {
		LibraryDAO libraryDAO = provider.getLibraryDAO();
		Library library;
		try {
			library = libraryDAO.getLibrary();
			library.getProducts().set(numProduct - 1, editedProduct);
			return libraryDAO.saveLibrary(library);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}			
	}

	@Override
	public boolean deleteProduct(int numProduct) throws ServiceException {
		LibraryDAO libraryDAO = provider.getLibraryDAO();
		Library library;
		try {
			library = libraryDAO.getLibrary();
			library.getProducts().remove(numProduct - 1);
			return libraryDAO.saveLibrary(library);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}		
	}

}
