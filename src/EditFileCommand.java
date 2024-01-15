import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EditFileCommand {
    public static void editFile(String fileName) {
        try {
            String fullPath = FileManager.getCurrentDirectory() + File.separator + fileName;
            FileWriter fileWriter = new FileWriter(fullPath);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter text for the file (Ctrl+D to save and exit):");
            while (scanner.hasNext()) {
                fileWriter.write(scanner.nextLine() + System.lineSeparator());
            }

            fileWriter.close();
            System.out.println("File edited: " + fullPath);
        } catch (IOException | SecurityException e) {
            System.out.println("Error editing the file: " + e.getMessage());
        }
    }
}
