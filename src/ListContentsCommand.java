import java.io.File;

public class ListContentsCommand {
    public static void listContents(String directoryName) {
        try {
            String fullPath = FileManager.getCurrentDirectory() + File.separator + directoryName;
            File directory = new File(fullPath);

            if (directory.isDirectory()) {
                File[] contents = directory.listFiles();

                if (contents != null && contents.length > 0) {
                    System.out.println("Contents of " + directoryName + ":");
                    for (File content : contents) {
                        System.out.println(content.getName());
                    }
                } else {
                    System.out.println("The directory is empty.");
                }
            } else {
                System.out.println("The provided path is not a directory.");
            }
        } catch (SecurityException e) {
            System.out.println("Permission denied: " + e.getMessage());
        }
    }
}
