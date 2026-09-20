package store;

import enums.Currency;
import model.App;

public class GooglePlayStore extends AppStore {

    public GooglePlayStore(Currency currency) {
        super("Google Play Store", currency);
    }

    @Override
    public boolean addApp(App app) {
        return super.addApp(app);
    }
}