package validation;

public class EmailValidator {

    private EmailValidator() {
    }

    public static boolean isValid(String email) {

        if (email == null) {
            return false;
        }

        return email.contains("@")
                && email.contains(".")
                && !email.startsWith("@")
                && !email.endsWith("@");
    }
}