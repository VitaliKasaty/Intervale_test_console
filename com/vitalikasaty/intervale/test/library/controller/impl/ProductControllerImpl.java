package com.vitalikasaty.intervale.test.library.controller.impl;

import java.util.List;

import com.vitalikasaty.intervale.test.library.bean.Product;
import com.vitalikasaty.intervale.test.library.controller.ProductController;
import com.vitalikasaty.intervale.test.library.service.ProductService;
import com.vitalikasaty.intervale.test.library.service.ServiceException;
import com.vitalikasaty.intervale.test.library.service.ServiceProvider;

public class ProductControllerImpl implements ProductController {

	private final ServiceProvider provider = ServiceProvider.getInstance();
	private ProductService productService = provider.getProductService();

	@Override
	public List<Product> doAction(String request) {
		List<Product> result = null;
		String commandName;
		String parameterToFind;
		commandName = request.split("=")[0];

		switch (commandName) {

		case "findProductByType":
			parameterToFind = request.split("=")[1];
			try {
				result = productService.findProductByType(parameterToFind);
			} catch (ServiceException e) {
				return null;
			}
			break;

		case "findProductByTitle":
			parameterToFind = request.split("=")[1];
			try {
				result = productService.findProductByTitle(parameterToFind);
			} catch (ServiceException e) {
				return null;
			}
			break;

		case "findProductByYearPublishing":
			parameterToFind = request.split("=")[1];
			try {
				result = productService.findProductByYearPublishing(Integer.parseInt(parameterToFind));
			} catch (ServiceException | NumberFormatException e) {
				return null;
			}
			break;

		case "findProductByTheme":
			parameterToFind = request.split("=")[1];
			try {
				result = productService.findProductByTheme(parameterToFind);
			} catch (ServiceException e) {
				return null;
			}
			break;
		}

		return result;
	}

}
