package io.khasang.homework.atm;

public class MasterCard extends Card {
    public MasterCard(long cardNumber, String cardHolderName) {
        super(cardNumber, cardHolderName);
        this.paymentSystem = "Master Card";
        System.out.printf("%nКарта %s %s создана.", paymentSystem, cardType);
    }

    @Override
    public double getCurrentCredit() {
        return 0;
    }

}
