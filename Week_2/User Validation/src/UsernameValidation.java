public class UsernameValidation implements UserValidation {

    private UserStorage storage;

    public UsernameValidation(UserStorage storage) {
        this.storage = storage;
    }

    @Override
    public boolean validate(User user) {

        if (user.getUsername() == null ||
                user.getUsername().isBlank()) {

            return false;
        }

        return !storage.usernameExists(user.getUsername());
    }

    public UserStorage getStorage() {
        return storage;
    }

    public void setStorage(UserStorage storage) {
        this.storage = storage;
    }
}