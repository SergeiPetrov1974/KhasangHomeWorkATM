package io.khasang.homework.atm;

public class CreditCard extends Card {
    private final double creditLimit;
    private double currentCredit;

    public CreditCard(long cardNumber, String cardHolderName, double creditLimit) {
        super(cardNumber, cardHolderName);
        this.cardType = "Credit";
        this.creditLimit = creditLimit;
        currentCredit = 0;
        System.out.println("");
    }

    @Override
    public void addCardMoney(double money) {
        if (currentCredit == 0) {
            balanceRub += money;
        } else {
            if (currentCredit >= money) {
                currentCredit -= money;
            } else {
                balanceRub += money - currentCredit;
                currentCredit = 0;
            }
        }
    }

    @Override
    public double getCardMoney(double moneySum) {
        if (balanceRub >= moneySum) {
            balanceRub -= moneySum;
            return moneySum;
        } else {
            if (balanceRub + creditLimit - currentCredit > moneySum) {
                currentCredit += moneySum - balanceRub;
                balanceRub = 0;
                return moneySum;
            } else {
                return 0;
            }
        }
    }

    @Override
    public double getBalanceRub() {
        return balanceRub + creditLimit - currentCredit;
    }

    @Override
    public double getCurrentCredit() {
        return currentCredit;
    }

}
