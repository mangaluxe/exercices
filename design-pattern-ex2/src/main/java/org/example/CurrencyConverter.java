package org.example;

public class CurrencyConverter {

    /**
     * Convertir vers USD
     * @param currency
     * @param amount
     */
    public void convertToUsd(String currency, double amount) {
        if (currency.equals("EUR")) {
            amount = amount * 1.1;
            System.out.println(amount + " USD");
        }
        if (currency.equals("USD")) {
            amount = amount * 1.3;
            System.out.println(amount + " USD");
        }
    }

    /**
     * Convertir depuis USD
     * @param currency
     * @param amount
     */
    public void convertFromUsd(String currency, double amount) {
        if (currency.equals("EUR")) {
            amount = amount / 1.1;
            System.out.println(amount + " EUR");
        }
        if (currency.equals("USD")) {
            amount = amount / 1.3;
            System.out.println(amount + " EUR");
        }
    }

}
