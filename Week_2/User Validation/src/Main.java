import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        UserStorage storage = new UserStorage();

        UserValidator validator = new UserValidator(storage);

        validator.addValidation(
                new PasswordValidation(
                        false,
                        true,
                        true,
                        true,
                        true
                )
        );

        validator.addValidation(
                new MinimumAgeValidation(18)
        );

        validator.addValidation(
                new EmailValidation()
        );

        validator.addValidation(
                new UsernameValidation(storage)
        );

        User user = new User(
                "Oleksii",
                "Password123!",
                "oleksii@gmail.com",
                LocalDate.of(2006, 9, 3)
        );

        boolean result = validator.validateUser(user);

        if (result) {
            System.out.println("User is valid.");
        } else {
            System.out.println("User is not valid.");
        }

        System.out.println(
                "Users in storage: " + storage.getUsers().size()
        );
    }
}