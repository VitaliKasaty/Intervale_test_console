package com.vitalikasaty.intervale.test.library;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.vitalikasaty.intervale.test.library.bean.Book;
import com.vitalikasaty.intervale.test.library.bean.Library;
import com.vitalikasaty.intervale.test.library.bean.Magazine;
import com.vitalikasaty.intervale.test.library.bean.Newspaper;
import com.vitalikasaty.intervale.test.library.bean.Product;
import com.vitalikasaty.intervale.test.library.dao.DAOException;
import com.vitalikasaty.intervale.test.library.dao.LibraryDAO;
import com.vitalikasaty.intervale.test.library.dao.impl.LibraryDAOImpl;
import com.vitalikasaty.intervale.test.library.presentation.MainMenu;

public class Main {
	public static void main(String[] args) throws DAOException {
		
		Date date = new Date();
		
		System.out.println(new SimpleDateFormat("dd.MM.yyyy").format(date));
		
		MainMenu mm = new MainMenu();
		mm.startProgram();
		
		Product book = new Book("title1", "theme1", "text1", new Date(), "author1");
		Product newspaper = new Newspaper("title2", "theme2", "text2", new Date(), "newsday1", "area1");
		List<String> editors = new ArrayList<>(Arrays.asList("Вася", "Петя", "Fedor"));
		Product magazine = new Magazine("title3", "theme3", "text3", new Date(), 12, editors);
				
		Library library = new Library();
		library.addProduct(magazine);
		library.addProduct(newspaper);
		library.addProduct(book);
		LibraryDAO libraryDao = new LibraryDAOImpl();
		//library = libraryDao.getLibrary();
		//libraryDao.saveLibrary(library);
		
		for (Product product : library.getProducts()) {
			System.out.println(product);
			System.out.println(product.getClass().getSimpleName());
		}
		System.out.println("------------");

		//PrintProduct pp = new PrintProduct();
		//pp.printProducts(library.getProducts());
		//libraryDao.saveLibrary(library);
//		


	}

}
