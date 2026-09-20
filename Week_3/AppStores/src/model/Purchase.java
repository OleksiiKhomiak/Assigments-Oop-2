package model;

import java.time.LocalDate;

public class Purchase {

    private User user;
    private App app;
    private LocalDate purchaseDate;

    public Purchase(User user, App app, LocalDate purchaseDate) {
        this.user = user;
        this.app = app;
        this.purchaseDate = purchaseDate;
    }

    public User getUser() {
        return user;
    }

    public App getApp() {
        return app;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
}