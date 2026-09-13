import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    private List<User> users;

    public UserStorage() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean usernameExists(String username) {

        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }

        return false;
    }

    public List<User> getUsers() {
        return users;
    }
}