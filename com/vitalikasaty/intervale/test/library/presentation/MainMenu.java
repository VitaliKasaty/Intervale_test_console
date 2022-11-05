package com.vitalikasaty.intervale.test.library.presentation;

import java.util.Scanner;

public class MainMenu {

	Scanner sc = new Scanner(System.in);

	public void startProgram() {

		String optionMainMenu = """
				1) Просмотр всей библиотеки.
				2) Просмотр книг.
				3) Просмотр журналов.
				4) Просмотр газет
				5) Выйти из библиотеки.
				""";
		
		boolean isActiveSession = true;
		
		while (isActiveSession) {
			
			System.out.println(optionMainMenu);
			String userInput = sc.nextLine();
			
			switch (userInput) {
				case "1":
					break;	
				case "2":
					break;
				case "3":
					break;
				case "4":
					break;
				case "5":
					isActiveSession = false;
					break;
				default:
					System.out.println("Такой команды нет, выберите подходящий вариант.\n");

			}
		}

	}
}
