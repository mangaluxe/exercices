package org.example.ex2;

/*
Exercice Java Lambda

1. Définir une classe Produit :
- La classe Produit contient les attributs nom, prix, quantite.

2. Définir des interfaces fonctionnelles personnalisées :

- FiltreProduit : Cette interface fonctionnelle prend un objet Produit et retourne un boolean pour indiquer si un produit passe le filtre.
- TransformationProduit : Cette interface fonctionnelle prend un Produit et retourne un Produit transformé.
- OperationProduit : Cette interface fonctionnelle permet d'appliquer une série d'opérations successives sur un Produit.

3. Exécuter des transformations et des filtres avec des lambdas :

- Crée filtre pour trouver les produits qui sont en stock (quantité > 0).
- Crée filtre pour trouver les produits par leur nom.
- Crée une transformation pour augmenter le prix des produits.
- Crée une transformation pour diminuer le prix des produits.
- Crée une transformation pour restocker un produit.
- Crée une transformation pour diminuer le stock un produit.
- Crée une série d'opérations successives pour diminuer le prix, puis ajouter un préfixe au nom du produit pour marquer une promotion.
*/


public class Main {
    public static void main(String[] args) {

        // ----- FiltreProduit -----

        // Crée filtre pour trouver les produits qui sont en stock (quantité > 0) :
        FiltreProduit filtreEnStock = produit -> produit.getQuantite() > 0;

        // Crée filtre pour trouver les produits par leur nom :
        String nom = "Jouet";
        FiltreProduit filtreNom = produit -> produit.getNom().equals(nom);

        // ----- TransformationProduit -----

        // Crée une transformation pour augmenter le prix des produits :
        TransformationProduit augmentationPrix = (produit) -> {
            float pourcentage = 1.2f;
            produit.setPrix(produit.getPrix() * pourcentage);
            return produit;
        };

        // Crée une transformation pour diminuer le prix des produits :
        TransformationProduit diminuerPrix = produit -> {
            float pourcentage2 = 0.8f;
            produit.setPrix(produit.getPrix() * pourcentage2);
            return produit;
        };

        // Crée une transformation pour restocker un produit :
        TransformationProduit restocker = produit -> {
            produit.setQuantite(produit.getQuantite() + 5);
            return produit;
        };

        // Crée une transformation pour diminuer le stock un produit :
        TransformationProduit destocker = produit -> {
            produit.setQuantite(produit.getQuantite() - 1);
            return produit;
        };

        // ----- OperationProduit -----

        // Crée une série d'opérations successives pour diminuer le prix, puis ajouter un préfixe au nom du produit pour marquer une promotion :
        OperationProduit operation = produit -> {
            produit.setPrix((float) (produit.getPrix() * 0.8));
            produit.setNom("Promo-" + produit.getNom());
            return produit;
        };

        // ----- Tests -----

        Produit produit = new Produit("Lego", 29.99f, 30);

        Produit p = restocker.transformer(produit);
        System.out.println("Nom: " + p.getNom()); // Affiche: Lego
        System.out.println("Prix: " + p.getPrix()); // Affiche: 29.99
        System.out.println("Quantite: " + p.getQuantite()); // Affiche: 35

        Produit p2 = operation.appliquer(produit);
        System.out.println("Nom: " + p2.getNom()); // Affiche: Promo-Lego
        System.out.println("Prix: " + p2.getPrix()); // Affiche: 23.992
        System.out.println("Quantite: " + p2.getQuantite()); // Affiche: 35

    }
}
