package io.khasang.homework.atm;

public class Atm {
    private double moneyATM;
    private Card cardInside;

    public Atm(double moneyATM) {
        this.moneyATM = moneyATM;
    }

    public void setCardInside(Card card) {
        if (!checkTheCard()) {
            this.cardInside = card;
            System.out.println("Карта вставлена.");
        } else {
            System.out.println("Слот занят");
        }
    }

    public void returnCard() {
        this.cardInside = null;
        System.out.println("Заберите свою карту.");
    }

    public void showCardBalance() {
        if (checkTheCard()) {
            if ("Credit".equals(cardInside.cardType)) {
                System.out.printf("%nНа карте есть кредитные %.0f и %.0f разрешенные рубли",
                        cardInside.getCurrentCredit(), cardInside.getBalanceRub());
            } else {
                System.out.printf("%nНа карте %.0f рублей.",
                        cardInside.getBalanceRub());
            }
        } else {
            System.out.println("\nКарты внутри нет.");
        }
    }

    public void getMoney(double sum) {
        if (checkTheCard()) {
            if (cardInside.getBalanceRub() < sum) {
                System.out.println("На карте недостаточно денег.");
            } else if (moneyATM < sum) {
                System.out.println("Не хватает денег в банкомате.");
            } else {
                moneyATM -= cardInside.getCardMoney(sum);
                System.out.println("Получите ваши деньги: " + sum);
            }
        } else {
            System.out.println("Карты внутри нет.");
        }
    }

    public void addMoney(double sum) {
        if (checkTheCard()) {
            cardInside.addCardMoney(sum);
            System.out.printf("%n%.0f На карту поступили средства", sum);
        }

    }

    boolean checkTheCard() {
        if (cardInside == null) {
            return false;
        }
        return true;
    }

}
