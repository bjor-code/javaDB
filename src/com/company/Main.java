package com.company;

import com.company.db.Delete;
import com.company.db.Insert;
import com.company.db.Tables;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        for (; ; ) {
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("|                               Что вы хотите сделать?                             |");
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("| 1. Вывести данные из БД\t | 2. Добавить данные в БД\t | 3. Удалить данные из БД |");
            System.out.println("|                              4. Выйти из программы                               |");
            System.out.println("------------------------------------------------------------------------------------");

            System.out.print("Выберите операцию: ");
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNextInt()) {
                if (!scanner.hasNextInt()) System.out.print("Вы ввели не число!\nВыберите операцию: ");
                scanner.next();
            }
            int number = scanner.nextInt();

            switch (number) {
                case 1 -> new Tables().GetTable();
                case 2 -> {
                    Scanner productName = new Scanner(System.in);
                    System.out.print("Input product name: ");
                    String name = productName.nextLine();
                    System.out.print("Input product price: ");
                    int price = scanner.nextInt();
                    new Insert().SetValues(name, price);
                }
                case 3 -> {
                    System.out.print("Введите номер строки который нужно удалить: ");
                    int row = scanner.nextInt();
                    new Delete().setDeleteRows(row);
                }
                case 4 -> {
                    System.out.println("Пока! :)");
                    System.exit(1);
                }
                default -> System.out.println("Error!");
            }
        }
    }
}