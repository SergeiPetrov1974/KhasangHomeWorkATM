package io.khasang.homework.atm;

public class VisaCard extends CreditCard {
    public VisaCard(long cardNumber, String cardHolderName, double creditLimit) {
        super(cardNumber, cardHolderName, creditLimit);
        this.paymentSystem = "Visa";
        System.out.printf("%nКарта %s %s создана.", paymentSystem, cardType);
    }

    @Override
    public double getCurrentCredit() {
        return super.getCurrentCredit();
    }
}
