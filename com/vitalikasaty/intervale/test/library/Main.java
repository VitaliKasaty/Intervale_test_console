package com.vitalikasaty.intervale.test.library;

import java.text.ParseException;
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
		
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		try {
			Date date2 = new Date();
			System.out.println(date2);
			Date date1 = dateFormat.parse("01.12.1992");
			date1 = new SimpleDateFormat("dd.MM.yyyy").parse("13.10.1980");
			System.out.println(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Product book = new Book("title1", "theme1", "text1", new Date(), "author1");
		Product newspaper = new Newspaper("title2", "theme2", "text2", new Date(), "newsday1", "area1");
		List<String> editors = new ArrayList<>(Arrays.asList("Вася", "Петя", "Fedor"));
		Product magazine = new Magazine("title3", "theme3", "text3", new Date(), 12, editors);
				
		Library library = new Library();
		library.addProduct(magazine);
		library.addProduct(newspaper);
		library.addProduct(book);
		LibraryDAO libraryDao = new LibraryDAOImpl();
		library = libraryDao.getLibrary();
		
		for (Product product : library.getProducts()) {
			System.out.println(product);
		}
		//libraryDao.saveLibrary(library);
//		
//		MainMenu menu = new MainMenu();
//		menu.startProgram();
//		
//		Book product1 = new Book();
//		product1.setAuthor("author1");
//		product1.setTitle("title1");
//		product1.setTheme("theme1");
//		product1.setText("text1");
//		product1.setYearPublishing(1976);
//		
//		Magazine product2 = new Magazine();
//		product2.setAuthor("author2");
//		product2.setTitle("title2");
//		product2.setTheme("theme2");
//		product2.setText("text2");
//		product2.setIssueNumber(1);
//		product2.setReleaseDate(null);
//		
//		//library.addProduct(product1);
//		//library.addProduct(product2);
//		
//		Newspaper product3 = new Newspaper("title3", "author3", "theme3", "text3", "newsofteday3", null);
//		//library.addProduct(product3);
//		
//		LibraryDAO libraryDao = new LibraryDAOImpl();
//		Library library = libraryDao.getLibrary();
//		
////		for (Product product : library.getLibraryProducts()) {
////			System.out.println(product);
////		}
//		//System.out.println(library.getLibraryProducts());
	}

}
