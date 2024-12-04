package org.example;

public class CurrencyConverter implements CurrencyAdapter {

//    public void convertToUsd(String currency, double amount) {
//        if (currency.equals("EUR")) {
//            amount = amount * 1.1;
//            System.out.println(amount + " USD");
//        }
//        if (currency.equals("USD")) {
//            amount = amount * 1.3;
//            System.out.println(amount + " USD");
//        }
//    }
//
//    public void convertFromUsd(String currency, double amount) {
//        if (currency.equals("EUR")) {
//            amount = amount / 1.1;
//            System.out.println(amount + " EUR");
//        }
//        if (currency.equals("USD")) {
//            amount = amount / 1.3;
//            System.out.println(amount + " EUR");
//        }
//    }


    @Override
    public void convert(String fromCurrency, String toCurrency, double amount) {
        if (fromCurrency.equals("USD")) {
            if (toCurrency.equals("EUR")) {
                double result = amount / 1.1;
                System.out.println(amount + " USD = " + result + " EUR");
            }
        } else if (fromCurrency.equals("EUR")) {
            if (toCurrency.equals("USD")) {
                double result = amount * 1.1;
                System.out.println(amount + " EUR = " + result + " USD");
            }
        }
    }
}
