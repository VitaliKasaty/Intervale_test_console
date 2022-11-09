package com.vitalikasaty.intervale.test.library.presentation;

import java.util.Scanner;

import com.vitalikasaty.intervale.test.library.controller.ControllerProvider;
import com.vitalikasaty.intervale.test.library.controller.LibraryController;

public class MainMenu {

	ControllerProvider controllerProvider = ControllerProvider.getInstanse();
	LibraryController libraryController = controllerProvider.getLibraryController();
	Scanner sc = new Scanner(System.in);

	public void startProgram() {

		String optionMainMenu = """
				1) Просмотр/изменение каталога библиотеки.
				2) Поиск/чтение печатного издания по критериям.
				3) Выйти из библиотеки.
				""";

		boolean isActiveSession = true;

		while (isActiveSession) {

			System.out.println(optionMainMenu);
			String userInput = sc.nextLine();

			switch (userInput) {
			case "1":
				ChangeLibraryOption changeLibraryOption = new ChangeLibraryOption();
				changeLibraryOption.menu();
				break;
			case "2":
				FindOption findOption = new FindOption();
				findOption.menu();
				break;
			case "3":
				System.out.println("До свидания!");
				isActiveSession = false;
				break;
			default:
				System.out.println("Такой команды нет, выберите подходящий вариант.\n");

			}
		}

	}
}
