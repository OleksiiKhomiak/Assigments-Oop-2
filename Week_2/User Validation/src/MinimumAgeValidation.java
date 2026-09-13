import java.time.LocalDate;
import java.time.Period;

public class MinimumAgeValidation implements UserValidation {

    private int minimumAge;

    public MinimumAgeValidation(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    @Override
    public boolean validate(User user) {

        if (user.getDateOfBirth() == null) {
            return false;
        }

        int age = Period.between(
                user.getDateOfBirth(),
                LocalDate.now()
        ).getYears();

        return age >= minimumAge;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }
}