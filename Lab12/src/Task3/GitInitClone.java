package Task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GitInitClone {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Util: java GitInitClone <cale>");
            System.exit(1);
        }

        String path = args[0];
        File gitDir = new File(path, ".git");

        try {
            // .git
            if (!gitDir.exists()) {
                if (!gitDir.mkdirs()) {
                    System.err.println("Nu am putut crea directorul .git");
                    System.exit(1);
                }
            }

           // objects & refs
            File objectsDir = new File(gitDir, "objects");
            if (!objectsDir.exists() && !objectsDir.mkdirs()) {
                System.err.println("Nu am putut crea directorul objects");
                System.exit(1);
            }

            File refsDir = new File(gitDir, "refs");
            if (!refsDir.exists() && !refsDir.mkdirs()) {
                System.err.println("Nu am putut crea directorul refs");
                System.exit(1);
            }

           // head
            File headFile = new File(gitDir, "HEAD");
            try (FileWriter writer = new FileWriter(headFile)) {
                writer.write("ref: refs/heads/main\n");
            }

            System.out.println("Git repository initialized at " + gitDir.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("A apărut o eroare: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
