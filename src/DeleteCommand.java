import java.io.File;

public class DeleteCommand {
    public static void deleteFile(String fileName) {
        try {
            String fullPath = FileManager.getCurrentDirectory() + File.separator + fileName;
            File file = new File(fullPath);

            if (file.delete()) {
                System.out.println("File deleted: " + fullPath);
            } else {
                System.out.println("Failed to delete the file.");
            }
        } catch (SecurityException e) {
            System.out.println("Permission denied: " + e.getMessage());
        }
    }

    public static void deleteDirectory(String directoryName) {
        try {
            String fullPath = FileManager.getCurrentDirectory() + File.separator + directoryName;
            File directory = new File(fullPath);

            if (directory.isDirectory()) {
                if (directory.listFiles().length == 0) {
                    if (directory.delete()) {
                        System.out.println("Directory deleted: " + fullPath);
                    } else {
                        System.out.println("Failed to delete the directory.");
                    }
                } else {
                    System.out.println("Directory is not empty. Use 'deletedirectoryforce' to delete it.");
                }
            } else {
                System.out.println("The provided path is not a directory.");
            }
        } catch (SecurityException e) {
            System.out.println("Permission denied: " + e.getMessage());
        }
    }
}
