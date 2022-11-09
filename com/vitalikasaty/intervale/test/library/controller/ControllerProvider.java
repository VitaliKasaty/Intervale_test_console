package com.vitalikasaty.intervale.test.library.controller;

import com.vitalikasaty.intervale.test.library.controller.impl.LibraryControllerImpl;
import com.vitalikasaty.intervale.test.library.controller.impl.ProductControllerImpl;

public final class ControllerProvider {

	private static final ControllerProvider instanse = new ControllerProvider();

	private LibraryController libraryController = new LibraryControllerImpl();
	private ProductController productController = new ProductControllerImpl();

	private ControllerProvider() {
	}

	public LibraryController getLibraryController() {
		return libraryController;
	}

	public void setLibraryController(LibraryController libraryController) {
		this.libraryController = libraryController;
	}

	public ProductController getProductController() {
		return productController;
	}

	public void setProductController(ProductController productController) {
		this.productController = productController;
	}

	public static ControllerProvider getInstanse() {
		return instanse;
	}

}
