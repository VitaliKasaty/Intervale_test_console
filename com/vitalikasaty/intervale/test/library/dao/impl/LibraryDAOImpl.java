package com.vitalikasaty.intervale.test.library.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

public class LibraryDAOImpl implements LibraryDAO{
	
	public static String pathFileResource = "src/com/vitalikasaty/intervale/test/library/resources/";
	@Override
	public boolean saveLibrary(Library library) throws DAOException {
		
		try (FileWriter writer = new FileWriter(pathFileResource + "Library.txt")){
			
			for (Product product : library.getProducts()) {
				
				String title = product.getTitle();				
				String theme = product.getTheme();
				String text = product.getText();
				Date releaseDate = product.getReleaseDate();
				String date = new SimpleDateFormat("dd.MM.yyyy").format(releaseDate);
				
				String infoProduct = product.getClass().getSimpleName() + "\n" + title + "\n" + theme 
						+ "\n" + text + "\n" + date + "\n";
				
				if (product instanceof Book) {					
					String author = ((Book) product).getAuthor();
					infoProduct += author + "\n||\n"; 
				} else if (product instanceof Magazine) {
					int issueNumber = ((Magazine) product).getIssueNumber();					
					infoProduct += issueNumber + "\n";
					List<String> editorList = ((Magazine) product).getEditors();
					String editorsLine = "";
					for (String editor : editorList) {						
						editorsLine += editor + "; ";						
					}
					infoProduct += editorsLine + "\n||\n";
					
				} else if (product instanceof Newspaper) {
					String newsOfTheDay = ((Newspaper) product).getNewsOfTheDay();
					String distributionArea =  ((Newspaper) product).getDistributionArea();
					infoProduct += newsOfTheDay + "\n" + distributionArea + "\n||\n";							
				}	
				writer.write(infoProduct);
			}
			writer.flush();							
			return true;
		} catch (IOException e) {
			throw new DAOException("Error file database", e);
		}		
		
	}

	@Override
	public Library getLibrary() throws DAOException {
		
		Library library = new Library();
		
		try(BufferedReader reader = new BufferedReader(new FileReader(pathFileResource + "Library.txt"))) {	
			
			String line;
			List<String> productInfo = new ArrayList<>();
			while ((line = reader.readLine()) != null) {
				
				if (!line.equals("||")) {
					productInfo.add(line);
				} else {			
					String typeProduct = productInfo.get(0);
					String title = productInfo.get(1);					
					String theme = productInfo.get(2);
					String text = productInfo.get(3);
					Date releaseDate = null;
					try {
						releaseDate = new SimpleDateFormat("dd.MM.yyyy").parse(productInfo.get(4));
					} catch (ParseException e) {						
						e.printStackTrace(); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!
					}
					
					if (typeProduct.equals("Book")) {
						String author = productInfo.get(5);
						Product book = new Book(title, theme, text, releaseDate, author);	
						library.addProduct(book);
					} else if (typeProduct.equals("Magazine")) {
						int issueNumber = Integer.parseInt(productInfo.get(5));						
						//String[] editorsArray = productInfo.get(5).split("; ");
						List<String> editors = new ArrayList<>(Arrays.asList(productInfo.get(5).split("; ")));
						Product magazine = new Magazine(title, theme, text, releaseDate, issueNumber, editors);
						library.addProduct(magazine);
					} else if (typeProduct.equals("Newspaper")) {
						String newsOfTheDay = productInfo.get(5);
						String distributionArea = productInfo.get(6);
						
						Product newspaper = new Newspaper(title, theme, text, releaseDate, newsOfTheDay, distributionArea);
						library.addProduct(newspaper);						
					}
					productInfo.clear();					
				}
				
			}
			
		} catch(IOException e) {
			throw new DAOException("Eror file database!", e);
		}
		return library;
	}

}
