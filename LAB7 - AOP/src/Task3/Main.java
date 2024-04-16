package Task3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            String fileName = "src/Task3/"+"fisier_" + i + ".txt";
            String content = i + " - " + LocalDateTime.now();

            try (FileWriter fileWriter = new FileWriter(fileName)) {
                fileWriter.write(content);
            } catch (IOException e) {
                System.out.println("Eroare la scrierea în file " + fileName + ": " + e.getMessage());
            }
        }
    }
}
