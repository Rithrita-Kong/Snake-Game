import java.util.Scanner;

public class SnakeGame {
    public static void main(String[] args) {
        // Setting up scanner and variables
        Scanner sc = new Scanner(System.in);
        String tmpName;
        String tmpPassword;
        int choice;
        boolean isLogin = false;
        User user;

        // Print out the registration/login screen
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("other. Quit");
        choice = sc.nextInt();
        String tmp = sc.nextLine();

        switch (choice) {
            case 1:
                do {
                    System.out.println("Input name: ");
                    tmpName = sc.nextLine();
                } while (Login.VerifyUserName(tmpName));
                System.out.println("Input password: ");
                tmpPassword = sc.nextLine();
                Register.registerUser(tmpName, tmpPassword);
                user = new User(tmpName, tmpPassword);
                isLogin = true;
                break;
            case 2:

                System.out.print("Input name: ");
                tmpName = sc.nextLine();
                System.out.print("Input password: ");
                tmpPassword = sc.nextLine();
                user = new User(tmpName, tmpPassword);
                isLogin = Login.loginUser(user);
            default:
                break;
        }

        sc.close();

        // If the user is login or exist, then the game will run
        if (isLogin) {

            Game level1 = new Game(1, 20, 750, 20, 20);
        } else {
            System.out.println("Failed to login!");
        }
    }
}
