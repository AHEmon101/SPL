import java.io.File;


public class MoveFileCommand {
    public static void moveFile(String sourceFileName, String destinationFileName) {
        try {
            String sourcePath = FileManager.getCurrentDirectory() + File.separator + sourceFileName;
            String destinationPath = FileManager.getCurrentDirectory() + File.separator + destinationFileName;

            File sourceFile = new File(sourcePath);
            File destinationFile = new File(destinationPath);

            if (sourceFile.exists() && sourceFile.renameTo(destinationFile)) {
                System.out.println("Moved: " + sourceFileName + " to " + destinationFileName);
            } else {
                System.out.println("Failed to move the file.");
            }
        } catch (SecurityException e) {
            System.out.println("Permission denied: " + e.getMessage());
        }
    }
}
