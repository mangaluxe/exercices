package org.example.ex23;

import java.util.ArrayList;
import java.util.List;


public class Panier {

    // ----- Propriétés -----

    private List<Article> articles;

    // ----- Constructeur -----

    public Panier() {
        this.articles = new ArrayList<>();
    }

    // ----- Getters/Setters -----

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    // ----- Méthodes -----

    public void addArticle(Article article) {
        this.articles.add(article);
    }

    public void removeArticle(Article article) {
        this.articles.remove(article);
    }

    @Override
    public String toString() {
        return "Panier [articles : " + articles + "]";
    }

}
