package org.example;

/*
Exercice : Adapter - Conversion de devises

Objectif :
Utilisez le pattern Adapter pour connecter une classe existante `CurrencyConverter` à une interface standardisée appelée `CurrencyAdapter`.
La classe existante utilise des taux fixes pour convertir des devises, mais l'interface impose un modèle générique.

Tâches :
1. Créez l'interface `CurrencyAdapter` avec une méthode `convert(String fromCurrency, String toCurrency, double amount)`.
2. Implémentez l'adaptateur pour utiliser les méthodes spécifiques de `CurrencyConverter`.
3. Testez la conversion entre plusieurs devises dans une classe principale.
*/

public class Main {
    public static void main(String[] args) {

        CurrencyConverter currencyConverter = new CurrencyConverter();

        currencyConverter.convert("EUR", "USD", 100); // 110.00000000000001 USD
        currencyConverter.convert("EUR", "USD", 150); // 165.0 USD

        currencyConverter.convert("USD", "EUR", 100); // 90.9090909090909 EUR
        currencyConverter.convert("USD", "EUR", 150); // 136.36363636363637 EUR

    }
}