import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- Secure Login System ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            try {

                switch (choice) {

                    case 1: {
                        System.out.print("Enter email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter password: ");
                        String password = sc.nextLine();

                        UserService.registerUser(email, password);
                        break;
                    }

                    case 2: {
                        System.out.print("Enter email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter password: ");
                        String password = sc.nextLine();

                        boolean success = UserService.loginUser(email, password);

                        if (success) {
                            System.out.println("Login successful.");
                        } else {
                            System.out.println("Invalid credentials.");
                        }
                        break;
                    }

                    case 3: {
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                    }

                    default: {
                        System.out.println("Invalid choice.");
                    }
                }

            } catch (InvalidUserException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (IOException e) {
                System.out.println("File error: " + e.getMessage());
            }
        }
    }
}