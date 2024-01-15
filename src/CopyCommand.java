import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CopyCommand {
    public static void copyFile(String sourceFileName, String destinationFileName) {
        try {
            String sourcePath = FileManager.getCurrentDirectory() + File.separator + sourceFileName;
            String destinationPath = FileManager.getCurrentDirectory() + File.separator + destinationFileName;

            File sourceFile = new File(sourcePath);
            File destinationFile = new File(destinationPath);

            if (sourceFile.exists()) {
                Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Copied: " + sourceFileName + " to " + destinationFileName);
            } else {
                System.out.println("Source file does not exist.");
            }
        } catch (IOException | SecurityException e) {
            System.out.println("Error copying the file: " + e.getMessage());
        }
    }
}
