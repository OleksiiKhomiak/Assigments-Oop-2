import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    private List<UserValidation> validations;
    private UserStorage storage;

    public UserValidator(UserStorage storage) {
        this.storage = storage;
        this.validations = new ArrayList<>();
    }

    public void addValidation(UserValidation validation) {
        validations.add(validation);
    }

    public void removeValidation(UserValidation validation) {
        validations.remove(validation);
    }

    public boolean validateUser(User user) {

        for (UserValidation validation : validations) {

            if (!validation.validate(user)) {
                return false;
            }
        }

        storage.addUser(user);

        return true;
    }

    public List<UserValidation> getValidations() {
        return validations;
    }

    public UserStorage getStorage() {
        return storage;
    }

    public void setStorage(UserStorage storage) {
        this.storage = storage;
    }
}