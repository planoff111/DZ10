package org.example;

import org.example.restorauntEntity.Zal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        chooseCast(choose());

    }

    public static int choose(){
        System.out.println("Добрий день. \n Присядете зa слолик?" +
                "\n1 - так" +
                "\n2 - Ні я піду тут не цікаво");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()){
            scanner.next();
            System.out.println("Введено недійсне значення. Будь ласка, введіть 1 або 2.");
        }
        int choose = scanner.nextInt();

        return choose;
    }

    public static void chooseCast(int choose) {
       Zal view = new Zal();

        view.welcome();
        switch (choose) {
            case 1:
                view.chooseMenu();


                break;
            case 2:
                System.out.println("Вже йдете( \n " +
                        "До побачення!");
                break;
            default:
                System.out.println("Немає такої опції(");

                break;


        }

    }

}