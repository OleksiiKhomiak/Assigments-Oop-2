package store;

import enums.Currency;
import model.App;
import model.Purchase;

public class AppleAppStore extends AppStore {

    private static final double STORE_REVENUE_PERCENTAGE = 0.70;

    public AppleAppStore(Currency currency) {
        super("Apple App Store", currency);
    }

    @Override
    public boolean addApp(App app) {

        if (app == null) {
            return false;
        }

        if (app.isContainsNudity()) {
            return false;
        }

        return super.addApp(app);
    }

    @Override
    public double getTotalRevenue() {

        double revenue = 0;

        for (Purchase purchase : purchases) {
            revenue += purchase.getApp().getPrice()
                    * STORE_REVENUE_PERCENTAGE;
        }

        return revenue;
    }

    @Override
    public double getRevenueForApp(App app) {

        double revenue = 0;

        for (Purchase purchase : purchases) {

            if (purchase.getApp() == app) {
                revenue += app.getPrice()
                        * STORE_REVENUE_PERCENTAGE;
            }
        }

        return revenue;
    }
}