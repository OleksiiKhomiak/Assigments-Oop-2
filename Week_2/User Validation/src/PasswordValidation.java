public class PasswordValidation implements UserValidation {

    private boolean spacesAllowed;
    private boolean specialCharactersRequired;
    private boolean numbersRequired;
    private boolean lowercaseRequired;
    private boolean uppercaseRequired;

    public PasswordValidation(
            boolean spacesAllowed,
            boolean specialCharactersRequired,
            boolean numbersRequired,
            boolean lowercaseRequired,
            boolean uppercaseRequired) {

        this.spacesAllowed = spacesAllowed;
        this.specialCharactersRequired = specialCharactersRequired;
        this.numbersRequired = numbersRequired;
        this.lowercaseRequired = lowercaseRequired;
        this.uppercaseRequired = uppercaseRequired;
    }

    @Override
    public boolean validate(User user) {

        String password = user.getPassword();

        if (password == null) {
            return false;
        }

        if (!spacesAllowed && password.contains(" ")) {
            return false;
        }

        if (specialCharactersRequired &&
                !password.matches(".*[^a-zA-Z0-9 ].*")) {
            return false;
        }

        if (numbersRequired &&
                !password.matches(".*\\d.*")) {
            return false;
        }

        if (lowercaseRequired &&
                !password.matches(".*[a-z].*")) {
            return false;
        }

        if (uppercaseRequired &&
                !password.matches(".*[A-Z].*")) {
            return false;
        }

        return true;
    }

    public boolean getSpacesAllowed() {
        return spacesAllowed;
    }

    public void setSpacesAllowed(boolean spacesAllowed) {
        this.spacesAllowed = spacesAllowed;
    }

    public boolean getSpecialCharactersRequired() {
        return specialCharactersRequired;
    }

    public void setSpecialCharactersRequired(boolean specialCharactersRequired) {
        this.specialCharactersRequired = specialCharactersRequired;
    }

    public boolean getNumbersRequired() {
        return numbersRequired;
    }

    public void setNumbersRequired(boolean numbersRequired) {
        this.numbersRequired = numbersRequired;
    }

    public boolean getLowercaseRequired() {
        return lowercaseRequired;
    }

    public void setLowercaseRequired(boolean lowercaseRequired) {
        this.lowercaseRequired = lowercaseRequired;
    }

    public boolean getUppercaseRequired() {
        return uppercaseRequired;
    }

    public void setUppercaseRequired(boolean uppercaseRequired) {
        this.uppercaseRequired = uppercaseRequired;
    }
}