package com.vitalikasaty.intervale.test.library.presentation;

import java.util.Scanner;

import com.vitalikasaty.intervale.test.library.controller.ControllerProvider;
import com.vitalikasaty.intervale.test.library.controller.LibraryController;

public class ChangeLibraryOption {
	
	ControllerProvider controllerProvider = ControllerProvider.getInstanse();
	LibraryController libraryController = controllerProvider.getLibraryController();
	Scanner sc = new Scanner(System.in);
	PrintProduct print = new PrintProduct();
	
	public void menu() {
		
		String optionMenu = """
				1) Добавить продукцию.
				2) Изменить продукцию.
				3) Удалить продукцию.
				4) Вернуться назад.
				""";
		
		boolean isActiveSession = true;
		
		while (isActiveSession) {
			print.printProducts(libraryController.getProducts("getProducts=all"));
			System.out.println(optionMenu);
			String userInput = sc.nextLine();
			
			switch (userInput) {
				case "1":
					break;
				case "2":
					break;
				case "3":
					int sizeCatalog = libraryController.getProducts("getProducts=all").size();
					System.out.println("Введите номер издания для удаления");
					int numDelete = 0;
					while (numDelete < 1 || numDelete > sizeCatalog) {
						numDelete = Integer.parseInt(sc.nextLine());
						
						if (numDelete > 0 && numDelete <= sizeCatalog) {
							libraryController.deleteProduct(numDelete);
						} else {
							System.out.println("Издания с таким номером не существует.");
						}
					}
					break;
				case "4":
					isActiveSession = false;
					break;
				default:
					System.out.println("Такой команды нет, выберите подходящий вариант.\n");
			}
		}
	}
}
