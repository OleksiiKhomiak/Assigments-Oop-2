package store;

import enums.Currency;
import exception.DownloadNotAllowedException;
import model.App;
import model.Purchase;
import model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class AppStore {

    private String name;
    private Currency currency;

    protected List<App> apps;
    protected List<Purchase> purchases;

    public AppStore(String name, Currency currency) {
        this.name = name;
        this.currency = currency;

        this.apps = new ArrayList<>();
        this.purchases = new ArrayList<>();
    }

    public boolean addApp(App app) {

        if (app == null) {
            return false;
        }

        apps.add(app);
        return true;
    }

    public void purchaseApp(User user, App app)
            throws DownloadNotAllowedException {

        if (user == null || app == null) {
            throw new DownloadNotAllowedException(
                    "User or app cannot be null."
            );
        }

        if (!apps.contains(app)) {
            throw new DownloadNotAllowedException(
                    "This app is not available in this store."
            );
        }

        int age = user.getAge();

        if (app.isContainsNudity() && age < 18) {
            throw new DownloadNotAllowedException(
                    "User must be at least 18 years old to download this app."
            );
        }

        if (app.isContainsViolence() && age < 16) {
            throw new DownloadNotAllowedException(
                    "User must be at least 16 years old to download this app."
            );
        }

        Purchase purchase = new Purchase(
                user,
                app,
                LocalDate.now()
        );

        purchases.add(purchase);
    }

    public double getTotalRevenue() {

        double revenue = 0;

        for (Purchase purchase : purchases) {
            revenue += purchase.getApp().getPrice();
        }

        return revenue;
    }

    public double getRevenueForApp(App app) {

        double revenue = 0;

        for (Purchase purchase : purchases) {

            if (purchase.getApp() == app) {
                revenue += app.getPrice();
            }
        }

        return revenue;
    }

    public List<App> getApps() {
        return apps;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public String getName() {
        return name;
    }

    public Currency getCurrency() {
        return currency;
    }
}