public class EmailValidation implements UserValidation {

    public EmailValidation() {
    }

    @Override
    public boolean validate(User user) {

        String email = user.getEmail();

        if (email == null) {
            return false;
        }

        return email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        );
    }
}