package org.example;

public class CurrencyConverterAdapter implements CurrencyAdapter {

    // ----- Propriétés -----

    private CurrencyConverter currencyConverter;

    // ----- Constructeur -----

    public CurrencyConverterAdapter() {
        this.currencyConverter = new CurrencyConverter();
    }

    // ----- Méthodes -----

    @Override
    public void convert(String fromCurrency, String toCurrency, double amount) {
        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            currencyConverter.convertFromUsd("EUR", amount);
        }
        else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            currencyConverter.convertToUsd("EUR", amount);
        }
        else {
            System.out.println("Erreur devise");
        }
    }
}
