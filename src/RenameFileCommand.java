import java.io.File;

public class RenameFileCommand {
    public static void renameFile(String oldName, String newName) {
        try {
            String oldFullPath = FileManager.getCurrentDirectory() + File.separator + oldName;
            File oldFile = new File(oldFullPath);

            if (oldFile.exists()) {
                String newFullPath = FileManager.getCurrentDirectory() + File.separator + newName;
                File newFile = new File(newFullPath);

                if (oldFile.renameTo(newFile)) {
                    System.out.println("Renamed to: " + newFullPath);
                } else {
                    System.out.println("Failed to rename the file or directory.");
                }
            } else {
                System.out.println("File or directory does not exist.");
            }
        } catch (SecurityException e) {
            System.out.println("Permission denied: " + e.getMessage());
        }
    }
}

