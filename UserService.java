import java.io.*;

class UserService {

    // Register new user
    public static void registerUser(String email, String password)
            throws InvalidUserException, IOException {

        // Validate email
        if (!Validator.isValidEmail(email)) {
            throw new InvalidUserException("Invalid email format.");
        }

        // Validate password
        if (!Validator.isValidPassword(password)) {
            throw new InvalidUserException("Password must be at least 6 characters and contain a digit.");
        }

        // Check if user already exists
        if (userExists(email)) {
            throw new InvalidUserException("User already exists.");
        }

        // Generate salt and hash password
        String salt = PasswordUtil.generateSalt();
        String hashedPassword = PasswordUtil.hashPassword(password, salt);

        // Save to file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt", true))) {
            bw.write(email + "," + hashedPassword + "," + salt);
            bw.newLine();
        }

        System.out.println("Registration successful.");
    }

    // Login user
    public static boolean loginUser(String email, String password) throws IOException {

        File file = new File("users.txt");

        if (!file.exists()) {
            return false;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                String storedEmail = parts[0];
                String storedHash = parts[1];
                String storedSalt = parts[2];

                if (storedEmail.equals(email)) {

                    String inputHash = PasswordUtil.hashPassword(password, storedSalt);

                    if (storedHash.equals(inputHash)) {
                        return true;
                    } else {
                        LoggerService.log("FAILED LOGIN: " + email);
                        return false;
                    }
                }
            }
        }

        LoggerService.log("FAILED LOGIN: " + email + " (User not found)");
        return false;
    }

    // Check if user already exists
    public static boolean userExists(String email) throws IOException {

        File file = new File("users.txt");

        if (!file.exists()) {
            return false;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts[0].equals(email)) {
                    return true;
                }
            }
        }

        return false;
    }
}