package io.khasang.homework.atm;

public abstract class Card {
    String paymentSystem;
    String cardType;
    String cardHolderName;
    protected long cardNumber;
    protected double balanceRub;

    public Card(long cardNumber, String cardHolderName) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.balanceRub = 0;
        cardType = "debit";
    }

    public void addCardMoney(double money) {
        balanceRub += money;
    }

    public double getCardMoney(double money) {
        if (balanceRub >= money) {
            balanceRub -= money;
            return money;
        } else {
            return 0;
        }
    }

    public double getBalanceRub() {
        return balanceRub;
    }

    public abstract double getCurrentCredit();
}
