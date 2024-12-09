package org.example.ex2;

// Cette interface fonctionnelle prend un objet Produit et retourne un boolean pour indiquer si un produit passe le filtre.
@FunctionalInterface
public interface FiltreProduit {

    boolean test(Produit produit);

}
