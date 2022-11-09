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
			List<Product> foundProducts;

			switch (userInput) {

			case "1":
				System.out.println("Введите тип печатного издания(Book, Newspaper, Magazine)");
				String typeProduct = sc.nextLine();
				if (typeProduct == "") {
					typeProduct = " ";
				}
				foundProducts = productController.doAction("findProductByType=" + typeProduct);
				print.printProducts(foundProducts);
				readProduct(foundProducts);
				break;

			case "2":
				System.out.println("Введите заголовок издания");
				String title = sc.nextLine();
				if (title == "") {
					title = " ";
				}
				foundProducts = productController.doAction("findProductByTitle=" + title);
				print.printProducts(foundProducts);
				readProduct(foundProducts);
				break;

			case "3":
				System.out.println("Введите год изданий");
				String yearPublishing = sc.nextLine();
				if (yearPublishing == "") {
					yearPublishing = " ";
				}
				foundProducts = productController.doAction("findProductByYearPublishing=" + yearPublishing);
				if (foundProducts != null) {
					print.printProducts(foundProducts);
					readProduct(foundProducts);
				}
				break;

			case "4":
				System.out.println("Введите жанр изданий");
				String theme = sc.nextLine();
				if (theme == "") {
					theme = " ";
				}
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

		int countProducts = products.size();

		if (countProducts == 0) {
			System.out.println("Нет доступных изданий!");
		} else {

			boolean isCorrectNum = false;
			int numToRead = 0;

			while (!isCorrectNum) {
				System.out.println("Для чтения издания введите его номер или '0', чтобы вернуться назад");

				try {
					numToRead = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
				}

				if (numToRead > 0 && numToRead <= countProducts) {
					print.readProduct(products, numToRead);
				} else if (numToRead == 0) {
					break;
				} else {
					System.out.println("Введите правильное число!");
				}
			}

		}

	}

}
