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

        // Utilisation de l'adaptateur pour effectuer la conversion
        CurrencyAdapter currencyAdapter = new CurrencyConverterAdapter();

        // Test de la conversion de USD à EUR
        currencyAdapter.convert("USD", "EUR", 100); // 100 USD to EUR

        // Test de la conversion de EUR à USD
        currencyAdapter.convert("EUR", "USD", 100); // 100 EUR to USD




    }
}