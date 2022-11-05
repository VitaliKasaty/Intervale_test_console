package com.vitalikasaty.intervale.test.library.controller;

import java.util.List;

import com.vitalikasaty.intervale.test.library.bean.Product;

public interface ProductController {
	List<Product> doAction(String reques);
}
