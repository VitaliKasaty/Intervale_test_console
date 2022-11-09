package com.vitalikasaty.intervale.test.library.presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.vitalikasaty.intervale.test.library.bean.Book;
import com.vitalikasaty.intervale.test.library.bean.Magazine;
import com.vitalikasaty.intervale.test.library.bean.Newspaper;
import com.vitalikasaty.intervale.test.library.bean.Product;
import com.vitalikasaty.intervale.test.library.controller.ControllerProvider;
import com.vitalikasaty.intervale.test.library.controller.LibraryController;

public class ChangeLibraryOption {

	ControllerProvider controllerProvider = ControllerProvider.getInstanse();
	LibraryController libraryController = controllerProvider.getLibraryController();
	PrintProduct print = new PrintProduct();
	Scanner sc = new Scanner(System.in);

	public void menu() {

		String optionMenu = """
				1) Добавить продукцию.
				2) Изменить продукцию.
				3) Удалить продукцию.
				4) Вернуться назад.
				""";

		boolean isActiveSession = true;

		while (isActiveSession) {
			System.out.println("Каталог библиотеки:");
			print.printProducts(libraryController.getProducts("getProducts=all"));
			System.out.println("====================================================");
			System.out.println(optionMenu);
			String userInput = sc.nextLine();

			switch (userInput) {
			case "1":
				if (addProduct()) {
					System.out.println("Издание успешно добавлено!");
				} else {
					System.out.println("Ошибка!");
				}
				break;
			case "2":
				if (editProduct()) {
					System.out.println("Издание изменено!");
				} else {
					System.out.println("Ошибка!");
				}
				break;
			case "3":
				if (deleteProduct()) {
					System.out.println("Издание удалено!");
				} else {
					System.out.println("Ошибка!");
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

	public boolean deleteProduct() {

		int sizeCatalog = libraryController.getProducts("getProducts=all").size();
		boolean isCorrectNum = false;
		int numDelete = 0;

		while (!isCorrectNum) {
			System.out.println("Введите номер издания для удаления");
			try {
				numDelete = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
			}

			if (numDelete <= 0 || numDelete > sizeCatalog) {
				System.out.println("Введите корректное число!");
			} else {
				isCorrectNum = true;
			}
		}

		return libraryController.deleteProduct(numDelete);
	}

	public boolean editProduct() {

		int countProducts = libraryController.getProducts("getProducts=all").size();

		boolean isCorrectNumProduct = false;
		int numProduct = 0;
		while (!isCorrectNumProduct) {
			System.out.println("Введите номер издания для изменения");
			try {
				numProduct = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Введите число!");
			}

			if (numProduct > 0 && numProduct <= countProducts) {
				isCorrectNumProduct = true;
			}
		}

		Product editedProduct = libraryController.getProducts("getProducts=all").get(numProduct - 1);
		System.out.print("""
				Какой параметр вы желаете изменить?
				1) Заголовок.
				2) Жанр.
				3) Текст
				4) Дату публикации
				""");

		if (editedProduct instanceof Book) {
			System.out.println("5) Автора издания");

		} else if (editedProduct instanceof Magazine) {

			System.out.println("""
					5) Номер выпуска
					6) Список редакторов
					""");

		} else if (editedProduct instanceof Newspaper) {
			System.out.println("""
					5) Новость дня
					6) Область распространения
					""");
		}

		boolean isCorrectEditField = false;
		int editField = 0;
		while (!isCorrectEditField) {
			try {
				editField = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
			}

			if (editedProduct instanceof Book) {
				if (editField > 0 && editField <= 5) {
					isCorrectEditField = true;
				}
			} else if (editField > 0 && editField <= 6) {
				isCorrectEditField = true;
			} else {
				System.out.println("Введите корректное число!");
			}

		}

		if (editField == 1) {
			System.out.println("Введите новый заголовок");
			String newTitle = sc.nextLine();
			editedProduct.setTitle(newTitle);

		} else if (editField == 2) {
			System.out.println("Введите новый жанр");
			String newTheme = sc.nextLine();
			editedProduct.setTheme(newTheme);

		} else if (editField == 3) {
			System.out.println("Введите новый текст");
			String newText = sc.nextLine();
			editedProduct.setText(newText);

		} else if (editField == 4) {
			System.out.println("Введите новый дату публикации (dd.mm.yyyy)");
			String newDate = sc.nextLine();
			try {
				editedProduct.setReleaseDate(new SimpleDateFormat("dd.MM.yyyy").parse(newDate));
			} catch (ParseException e) {
			}

		} else if (editField == 5 && editedProduct instanceof Book) {
			System.out.println("Введите нового автора");
			String newAuthor = sc.nextLine();
			((Book) editedProduct).setAuthor(newAuthor);

		} else if (editField == 5 && editedProduct instanceof Magazine) {
			System.out.println("Введите нового номер выпыска");
			int newIssueNumber = Integer.parseInt(sc.nextLine());
			((Magazine) editedProduct).setIssueNumber(newIssueNumber);

		} else if (editField == 6 && editedProduct instanceof Magazine) {
			System.out.println("Введите нового список редакторов чверез ','");
			String newEditorsLine = sc.nextLine();
			List<String> newEditors = Arrays.asList(newEditorsLine.split(","));
			((Magazine) editedProduct).setEditors(newEditors);

		} else if (editField == 5 && editedProduct instanceof Newspaper) {
			System.out.println("Введите новую новость дня");
			String newNewsOfTheDay = sc.nextLine();
			((Newspaper) editedProduct).setNewsOfTheDay(newNewsOfTheDay);

		} else if (editField == 6 && editedProduct instanceof Newspaper) {
			System.out.println("Введите новую область распространения");
			String newDistributionArea = sc.nextLine();
			((Newspaper) editedProduct).setDistributionArea(newDistributionArea);

		}

		if (libraryController.editProduct(numProduct, editedProduct)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean addProduct() {

		String typeMenu = """
				Какой тип издания вы хотите добавить?
				1) Книга.
				2) Журнал.
				3) Газета.
				""";

		int typeProduct = 0;
		Product product = null;

		while (typeProduct == 0) {
			System.out.println(typeMenu);
			String userInput = sc.nextLine();
			switch (userInput) {
			case "1":
				typeProduct = 1;
				break;
			case "2":
				typeProduct = 2;
				break;
			case "3":
				typeProduct = 3;
				break;
			default:
				System.out.println("Такого типа издания нет, выберите подходящий вариант.\n");
			}
		}

		System.out.println("Введите заголовок");
		String title = sc.nextLine();
		System.out.println("Введите жанр");
		String theme = sc.nextLine();
		boolean isCorrectDate = false;
		String dateRelease = null;

		while (!isCorrectDate) {
			System.out.println("Введите дату публикации (dd.mm.yyyy)");
			String dateRegex = "(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((18|19|20)\\d\\d)";
			String inputDate = sc.nextLine();
			if (inputDate.matches(dateRegex)) {
				dateRelease = inputDate;
				isCorrectDate = true;
			} else {
				System.out.println("Введите корректную дату!");
			}
		}

		Date date = null;
		try {
			date = new SimpleDateFormat("dd.mm.yyyy").parse(dateRelease);
		} catch (ParseException e) {
		}

		System.out.println("Введите текст издания");
		String text = sc.nextLine();

		if (typeProduct == 1) {

			System.out.println("Введите автора");
			String author = sc.nextLine();
			product = new Book(title, theme, text, date, author);

		} else if (typeProduct == 2) {

			boolean isCorrectIssueNumber = false;
			int issueNumber = 0;
			while (!isCorrectIssueNumber) {
				System.out.println("Введите номер выпуска");
				try {
					issueNumber = Integer.parseInt(sc.nextLine());
					isCorrectIssueNumber = true;
				} catch (Exception e) {
					System.out.println("Введите число!");
				}
			}

			System.out.println("Введите список редакторов через ','");
			String editorsLine = sc.nextLine();
			List<String> editors = Arrays.asList(editorsLine.split(","));
			product = new Magazine(title, theme, text, date, issueNumber, editors);

		} else if (typeProduct == 3) {

			System.out.println("Введите новость дня выпуска");
			String newsOfTheDay = sc.nextLine();
			System.out.println("Введите область распространения");
			String distributionArea = sc.nextLine();
			product = new Newspaper(title, theme, text, date, newsOfTheDay, distributionArea);

		}

		if (libraryController.addProduct(product)) {
			return true;
		} else {
			return false;
		}

	}
}
