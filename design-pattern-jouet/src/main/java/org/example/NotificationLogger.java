package org.example;

public class NotificationLogger implements Observer {

    @Override
    public void update(String message) {
        System.out.println("Affichage message : " + message + ". Notification envoyée !");
    }

}
