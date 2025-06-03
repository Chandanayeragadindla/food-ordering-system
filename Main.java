import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter email");
        String email = sc.nextLine();

        System.out.println("Enter password");
        String password = sc.next();

        boolean isLogin = DataBaseConnection.checkLoginCredentials(email, password);

        if (isLogin) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
            System.out.println("Please ReLogin");

            sc.nextLine(); // Consume leftover newline
            System.out.println("Enter email");
            email = sc.nextLine();

            System.out.println("Enter password");
            password = sc.next();

            DataBaseConnection.RegisterUser(email, password);

            if (DataBaseConnection.checkLoginCredentials(email, password)) {
                System.out.println("Logged in successfully");
            } else {
                System.out.println("Something went wrong");
                sc.close();
                return;
            }
        }

        User user = new User();
        user.displayItems();
        user.selectItems();

        sc.close();
    }
}
