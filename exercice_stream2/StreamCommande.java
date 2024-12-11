import java.util.*;
import java.util.stream.Collectors;


class Commande {

    // ----- Propriétés -----

    private int id;
    private String client;
    private List<String> articles;
    private double montantTotal;
    private boolean estLivree;

    // ----- Constructeur -----

    public Commande(int id, String client, List<String> articles, double montantTotal, boolean estLivree) {
        this.id = id;
        this.client = client;
        this.articles = articles;
        this.montantTotal = montantTotal;
        this.estLivree = estLivree;
    }

    // ----- Getters -----

    public int getId() {
        return id;
    }
    public String getClient() {
        return client;
    }
    public List<String> getArticles() {
        return articles;
    }
    public double getMontantTotal() {
        return montantTotal;
    }
    public boolean getEstLivree() {
        return estLivree;
    }

    // ----- Méthodes -----

    @Override
    public String toString() {
        return "Commande [" + "ID : " + id + ", Client : '" + client + '\'' + ", Articles : " + articles + ", Montant total : " + montantTotal + ", Est livrée : " + estLivree + ']';
    }
}

/*
Exercice Java Stream. Implémenter les différentes tâches suivantes en utilisant Stream :

1. Afficher toutes les commandes.
2. Récupérer et afficher le nom des clients de chaque commande.
3. Calculer et afficher le montant total de toutes les commandes.
4. Afficher les articles et le prix total pour chaque commande.
5. Lister les commandes livrées : Utiliser Stream.filter pour filtrer les commandes livrées.
6. Calculer le montant total par client : Grouper les commandes par client avec Collectors.groupingBy et calculer la somme des montants
7. Obtenir les articles uniques commandés 
8. Vérifier si tous les clients ont une commande livrée : Grouper par client et utiliser Stream.allMatch pour vérifier la condition.
*/


public class StreamCommande {
    public static void main(String[] args) {

        // Liste de commandes
        List<Commande> commandes = Arrays.asList(
                new Commande(1, "Alice", Arrays.asList("Ordinateur", "Souris"), 1200.50, true),
                new Commande(2, "Bob", Arrays.asList("Clavier", "Écran"), 300.75, false),
                new Commande(3, "Charlie", Arrays.asList("Imprimante"), 150.00, true),
                new Commande(4, "Alice", Arrays.asList("USB", "Casque"), 75.50, false),
                new Commande(5, "Bob", Arrays.asList("Tablette"), 200.00, true)

        );

        System.out.println("\n----- 1. Afficher toutes les commandes -----\n");
        commandes.stream()
            .forEach(commande -> System.out.println(commande));


        System.out.println("\n----- 2. Récupérer et afficher le nom des clients de chaque commande -----\n");
        commandes.stream()
            // .map(commande -> commande.getClient()) // Méthode 1
            .map(Commande::getClient) // Méthode 2
            .forEach(client -> System.out.println(client)); // Affiche juste client

        
        System.out.println("\n----- 3. Calculer et afficher le montant total de toutes les commandes -----\n");
        double grandTotal = commandes.stream()
            .mapToDouble(Commande::getMontantTotal)
            .sum();
        System.out.println("Le montant total de toutes les commandes est de : " + grandTotal);


        System.out.println("\n----- 4. Afficher les articles et le prix total pour chaque commande -----\n");
        commandes.stream()
            .forEach(commande -> System.out.println(commande.getArticles() + " : " + commande.getMontantTotal()));


        System.out.println("\n----- 5. Lister les commandes livrées : Utiliser Stream.filter pour filtrer les commandes livrées -----\n");
        commandes.stream()
            // .filter(commande -> commande.getEstLivree().equals(true)) // Ne marche pas
            .filter(commande -> commande.getEstLivree())
            .forEach(System.out::println);


        System.out.println("\n----- 6. Calculer le montant total par client : Grouper les commandes par client avec Collectors.groupingBy et calculer la somme des montants -----\n");
        commandes.stream()
            .collect(Collectors.groupingBy(Commande::getClient, Collectors.summingDouble(Commande::getMontantTotal)))
            .forEach((client, total) -> System.out.println(client + " : " + total));

        
        System.out.println("\n----- 7. Obtenir les articles uniques commandés -----\n");
        commandes.stream()
            .map(Commande::getArticles)
            .distinct()
            .forEach(System.out::println);


        System.out.println("\n----- 8. Vérifier si tous les clients ont une commande livrée : Grouper par client et utiliser Stream.allMatch pour vérifier la condition -----\n");
        boolean bool = commandes.stream()
            .allMatch(commande -> commande.getEstLivree());
        System.out.println("Toutes les commandes sont livrées : " + bool);

    }
}