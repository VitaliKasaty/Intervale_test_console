package com.vitalikasaty.intervale.test.library.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.vitalikasaty.intervale.test.library.bean.Product;
import com.vitalikasaty.intervale.test.library.controller.LibraryController;
import com.vitalikasaty.intervale.test.library.service.LibraryService;
import com.vitalikasaty.intervale.test.library.service.ServiceProvider;

public class LibraryControllerImpl implements LibraryController {

	private final ServiceProvider provider = ServiceProvider.getInstance();
	LibraryService libraryService = provider.getLibraryService(); // !!!!!!!!!!!!!!

	@Override
	public boolean addProduct(Product product) {
		try {
			return libraryService.addProduct(product);
		} catch (Exception e) {
			return false; // !!!!!!!!!!!!!!!!!!!!!!
		}
	}

	@Override
	public boolean editProduct(int numProduct, Product editedProduct) {
		try {
			return libraryService.editProdict(numProduct, editedProduct);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteProduct(int numProduct) {
		try {
		return libraryService.deleteProduct(numProduct);
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public List<Product> getProducts(String request) {
		List<Product> result = null;
		String commandName;
		String parametrToFind;
		commandName = request.split("=")[0];

		switch (commandName) {
		case "getProducts":

			parametrToFind = request.split("=")[1];
			if (parametrToFind.equals("all")) {
				try {
					result = libraryService.getLibrary().getProducts();
				} catch (Exception e) {
					// !!!!
				}
			} else if (parametrToFind.equals("magazines")) {
				try {
					result = libraryService.getLibrary().getProducts().stream()
							.filter(x -> x.getClass().getSimpleName().equals("Magazine")).collect(Collectors.toList());
				} catch (Exception e) {
					// !!!!
				}
			} else if (parametrToFind.equals("newspapers")) {
				try {
					result = libraryService.getLibrary().getProducts().stream()
							.filter(x -> x.getClass().getSimpleName().equals("Newspaper")).collect(Collectors.toList());
				} catch (Exception e) {
					// TODO: handle exception
				}

			} else if (parametrToFind.equals("books")) {
				try {
					result = libraryService.getLibrary().getProducts().stream()
							.filter(x -> x.getClass().getSimpleName().equals("Book")).collect(Collectors.toList());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			break;
		}

		return result;
	}

}
