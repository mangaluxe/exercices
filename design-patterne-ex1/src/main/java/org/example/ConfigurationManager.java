package org.example;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {

    // ----- Propriétés -----

    private static ConfigurationManager instance = null; // 💡 1. Instance unique de la classe (statique privée)
    private final Map<String, String> configurations = new HashMap<>(); // Stockage des configurations

    // ----- Constructeur (💡 2. Constructeur privé pour empêcher l'instanciation) -----

    private ConfigurationManager() {
        System.out.println("Instance Singleton créée.");

        configurations.put("db.host", "localhost");
        configurations.put("db.port", "5432");
        configurations.put("app.name", "MyApplication");
    }

    // ----- Méthodes -----

    /**
     * Méthode statique pour récupérer l'instance unique (💡 3. Méthode d'accès en publique pour accéder à cette instance)
     */
    public static ConfigurationManager getInstance() {
        if (instance == null) { // 💡 Crée l'instance si elle n'existe pas encore
            instance = new ConfigurationManager();
        }
        return instance;
    }

    /**
     * Afficher message de test
     */
    public void test() {
        System.out.println("Test ok");
    }

    /**
     * Récupérer une configuration par clé
     */
    public String getConfiguration(String key) {
        return configurations.get(key);
    }

}
