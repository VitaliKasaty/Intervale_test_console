package com.vitalikasaty.intervale.test.library.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.vitalikasaty.intervale.test.library.bean.Product;
import com.vitalikasaty.intervale.test.library.dao.DAOException;
import com.vitalikasaty.intervale.test.library.dao.DAOProvider;
import com.vitalikasaty.intervale.test.library.dao.LibraryDAO;
import com.vitalikasaty.intervale.test.library.service.ProductService;
import com.vitalikasaty.intervale.test.library.service.ServiceException;

public class ProductServiceImpl implements ProductService {

	private final DAOProvider provider = DAOProvider.getInstance();
	LibraryDAO libraryDAO = provider.getLibraryDAO();

	@Override
	public List<Product> getProducts() throws ServiceException {

		try {
			return libraryDAO.getLibrary().getProducts();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public Product getProduct(int numProduct) throws ServiceException {
		return getProducts().get(numProduct - 1);
	}

	@Override
	public List<Product> findProductByType(String type) throws ServiceException {
		return getProducts().stream().filter(product -> product.getClass().getSimpleName().equals(type))
				.collect(Collectors.toList());
	}

	@Override
	public List<Product> findProductByTitle(String title) throws ServiceException {
		return getProducts().stream().filter(product -> product.getTitle().equals(title))
				.collect(Collectors.toList());
	}

	@Override
	public List<Product> findProductByTheme(String theme) throws ServiceException {
		return getProducts().stream().filter(product -> product.getTheme().equals(theme))
				.collect(Collectors.toList());
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Product> findProductByYearPublishing(int year) throws ServiceException {
		return getProducts().stream().filter(product -> product.getReleaseDate().getYear() + 1900 == year)
				.collect(Collectors.toList());
	}

}
