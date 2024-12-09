package org.example.ex2;

// Cette interface fonctionnelle prend un Produit et retourne un Produit transformé.
@FunctionalInterface
public interface TransformationProduit {

    Produit transformer(Produit produit);

}
