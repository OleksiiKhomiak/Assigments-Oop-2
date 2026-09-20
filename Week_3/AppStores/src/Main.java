package app;

import enums.Currency;
import exception.DownloadNotAllowedException;
import model.App;
import model.User;
import store.AppleAppStore;
import store.GooglePlayStore;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        AppleAppStore appleStore =
                new AppleAppStore(Currency.EUR);

        GooglePlayStore googleStore =
                new GooglePlayStore(Currency.EUR);


        App minecraft = new App(
                "Minecraft",
                20.00,
                false,
                false
        );

        App violentGame = new App(
                "Violent Game",
                30.00,
                true,
                false
        );

        App adultApp = new App(
                "Adult App",
                15.00,
                false,
                true
        );


        User adultUser = new User(
                "Sally",
                "sally@gmail.com",
                LocalDate.of(2000, 5, 10)
        );

        User youngUser = new User(
                "John",
                "john@gmail.com",
                LocalDate.of(2015, 4, 20)
        );


        appleStore.addApp(minecraft);
        appleStore.addApp(violentGame);

        boolean adultAppAdded =
                appleStore.addApp(adultApp);

        System.out.println(
                "Adult app added to Apple Store: "
                        + adultAppAdded
        );


        googleStore.addApp(minecraft);
        googleStore.addApp(violentGame);
        googleStore.addApp(adultApp);


        try {

            appleStore.purchaseApp(
                    adultUser,
                    minecraft
            );

            appleStore.purchaseApp(
                    adultUser,
                    violentGame
            );

            System.out.println(
                    "Adult user purchases successful."
            );

        } catch (DownloadNotAllowedException e) {

            System.out.println(
                    e.getMessage()
            );
        }


        try {

            googleStore.purchaseApp(
                    youngUser,
                    violentGame
            );

        } catch (DownloadNotAllowedException e) {

            System.out.println(
                    "Purchase failed: " + e.getMessage()
            );
        }


        System.out.println(
                "Apple total revenue: "
                        + appleStore.getTotalRevenue()
                        + " "
                        + appleStore.getCurrency()
        );

        System.out.println(
                "Minecraft revenue: "
                        + appleStore.getRevenueForApp(minecraft)
                        + " "
                        + appleStore.getCurrency()
        );
    }
}