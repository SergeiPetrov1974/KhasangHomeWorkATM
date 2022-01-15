package io.khasang.homework.atm;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private int choose = 6;
    private Atm atm;

    public Menu(Atm atm) {
        this.atm = atm;
    }

    void showMenu() {
        int choose1 = 3;
        do {
            System.out.println("Выберте действие:");
            System.out.println("1. Вставить карту Visa");
            System.out.println("2. Вставить карту MasterCard");
            System.out.println("3. Выйти");
            System.out.println("_");
            choose1 = chooseAction();

            switch (choose1) {
                case 1:
                    atm.setCardInside(new VisaCard(0001, "Ivan Ivanov", 150000));
                    cardMenu();
                    break;
                case 2:
                    atm.setCardInside(new MasterCard(0002, "Petr Petrov"));
                    cardMenu();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Введите правильные цифры");
                    break;
            }
        } while (choose1 != 3);
    }

    void cardMenu() {
        do {
            System.out.println("\nВыберите дальнейшие действия:");
            System.out.println("1. Показать баланс карты");
            System.out.println("2. Выдать наличные");
            System.out.println("3. Внести наличные");
            System.out.println("4. Вернуть карту и выйти");
            System.out.println("_");
            choose = chooseAction();
            switch (choose) {
                case 1:
                    atm.showCardBalance();
                    break;
                case 2:
                    atm.getMoney(askAmount());
                    break;
                case 3:
                    atm.addMoney(askAmount());
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Введите правильные цифры");
                    break;
            }
        } while (choose != 4);
        atm.returnCard();
    }

    int chooseAction() {
        int action = scanner.nextInt();
        scanner.nextLine();
        return action;
    }

    double askAmount() {
        System.out.println("Введите сумму");
        System.out.println("_");
        Double amount = scanner.nextDouble();
        scanner.nextLine();
        return amount;
    }
}
