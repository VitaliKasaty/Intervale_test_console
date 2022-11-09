package com.vitalikasaty.intervale.test.library.service;

import com.vitalikasaty.intervale.test.library.service.impl.LibraryServiceImpl;
import com.vitalikasaty.intervale.test.library.service.impl.ProductServiceImpl;

public final class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();
	private final LibraryService libraryService = new LibraryServiceImpl();
	private final ProductService productService = new ProductServiceImpl();

	private ServiceProvider() {
	}

	public LibraryService getLibraryService() {
		return libraryService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

}
