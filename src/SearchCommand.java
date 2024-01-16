import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchCommand {
    public static List<String> searchFiles(String directoryName, String query) {
        List<String> foundFiles = new ArrayList<>();

        try {
            String fullPath = FileManager.getCurrentDirectory() + File.separator + directoryName;
            File directory = new File(fullPath);

            if (directory.isDirectory()) {
                searchFilesInDirectory(directory, query, foundFiles);
            } else {
                System.out.println("The provided path is not a directory.");
            }
        } catch (SecurityException e) {
            System.out.println("Permission denied: " + e.getMessage());
        }

        return foundFiles;
    }

    private static void searchFilesInDirectory(File directory, String query, List<String> foundFiles) {
        File[] contents = directory.listFiles();

        if (contents != null) {
            for (File content : contents) {
                if (content.isDirectory()) {
                    searchFilesInDirectory(content, query, foundFiles);
                } else if (content.getName().contains(query)) {
                    foundFiles.add(content.getAbsolutePath());
                }
            }
        }
    }
}
