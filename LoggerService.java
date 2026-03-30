import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

class LoggerService {

    public static void log(String message) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("logs.txt", true))) {

            bw.write("[" + LocalDateTime.now() + "] " + message);
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error writing to log file.");
        }
    }
}