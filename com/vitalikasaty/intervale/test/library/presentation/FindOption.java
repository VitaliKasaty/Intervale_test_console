package com.vitalikasaty.intervale.test.library.presentation;

import java.util.List;
import java.util.Scanner;

import com.vitalikasaty.intervale.test.library.bean.Product;
import com.vitalikasaty.intervale.test.library.controller.ControllerProvider;
import com.vitalikasaty.intervale.test.library.controller.ProductController;

public class FindOption {
	ControllerProvider controllerProvider = ControllerProvider.getInstanse();
	ProductController productController = controllerProvider.getProductController();
	PrintProduct print = new PrintProduct();
	Scanner sc = new Scanner(System.in);
	
	public void menu() {
		
		String option = """
				Выберите действие.
				1) Поиск по типу печатного издания.				
				2) Поиск по заголовку издания.
				3) Поиск по году публикации.
				4) Поиск по жанру.
				5) Вернуться назад.
				""";
		
		boolean isActiveSession = true;
		
		while (isActiveSession) {
			System.out.println(option);
			String userInput = sc.nextLine();
			List<Product> foundProducts;;
			
			switch (userInput) {
			case "1":
				System.out.println("Введите тип печатного издания(Book, Newspaper, Magazine)");
				String typeProduct = sc.nextLine();
				foundProducts = productController.doAction("findProductByType=" + typeProduct);
				print.printProducts(foundProducts);
				readProduct(foundProducts);
				break;
			case "2":
				System.out.println("Введите заголовок издания");
				String title = sc.nextLine();
				foundProducts = productController.doAction("findProductByTitle=" + title);
				print.printProducts(foundProducts);
				readProduct(foundProducts);
				break;
			case "3":
				System.out.println("Введите год изданий");
				String yearPublishing= sc.nextLine();
				foundProducts = productController.doAction("findProductByYearPublishing=" + yearPublishing);
				print.printProducts(foundProducts);
				readProduct(foundProducts);
				break;
			case "4":
				System.out.println("Введите жанр изданий");
				String theme = sc.nextLine();
				foundProducts = productController.doAction("findProductByTheme=" + theme);
				print.printProducts(foundProducts);
				readProduct(foundProducts);
				break;
			case "5":
				isActiveSession = false;
				break;
			default:
				System.out.println("Такой команды нет!");	
			}
			
		}
	}
	
	public void readProduct(List<Product> products) {
		System.out.println("Для чтения издания введите его номер или '0', чтобы вернуться назад");
		int num = Integer.parseInt(sc.nextLine());
		if (num != 0) {
			print.readProduct(products, num);
		}
	}

}
