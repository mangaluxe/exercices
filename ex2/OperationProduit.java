package org.example.ex2;

/*
Cette interface fonctionnelle permet d'appliquer une série d'opérations successives sur un Produit.
*/
@FunctionalInterface
public interface OperationProduit {

    Produit appliquer(Produit produit);

}
