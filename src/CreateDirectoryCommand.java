import java.io.File;

public class CreateDirectoryCommand {
    public static void createDirectory(String directoryName) {
        try {
            String fullPath = FileManager.getCurrentDirectory() + File.separator + directoryName;
            File directory = new File(fullPath);

            if (directory.mkdir()) {
                System.out.println("Directory created: " + fullPath);
            } else {
                System.out.println("Failed to create the directory.");
            }
        } catch (SecurityException e) {
            System.out.println("Permission denied: " + e.getMessage());
        }
    }
}
