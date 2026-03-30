import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

class PasswordUtil {

    // Generate a random salt
    public static String generateSalt() {
        return UUID.randomUUID().toString();
    }

    // Hash password + salt using SHA-256
    public static String hashPassword(String password, String salt) {

        String combined = password + salt;

        try {
            // Get SHA-256 hashing instance
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Apply hashing
            byte[] hashBytes = md.digest(combined.getBytes());

            // Convert bytes to readable hex string
            StringBuilder sb = new StringBuilder();

            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: SHA-256 not found");
            return null;
        }
    }
}