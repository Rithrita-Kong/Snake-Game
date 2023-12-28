import java.util.List;

public class Authenticate {

    // Example method to authenticate a user
    public static boolean authenticateUser(String username, String password) {
        User user = Database.getUserByUsername(username);

        if (user != null && user.checkLogin(password)) {
            return true;
        }

        return false;
    }
}

class User {
    private String username;
    private String hashedPassword;

    public User(String username, String hashedPassword) {
        this.username = username;
        this.hashedPassword = hashedPassword;
    }

    public boolean checkLogin(String inputPassword) {
        // Use a library like BCrypt to verify the hashed password
        return BCrypt.checkpw(inputPassword, hashedPassword);
    }

    // Getters and setters
}

class Database {
    private static List<User> users = List.of(
            new User("user1", BCrypt.hashpw("password1", BCrypt.gensalt())),
            new User("user2", BCrypt.hashpw("password2", BCrypt.gensalt()))
    );

    // Example method to retrieve a user by username
    public static User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
