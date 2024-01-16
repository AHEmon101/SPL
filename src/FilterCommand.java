import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilterCommand {
    public static List<String> filterFiles(String directoryName, String fileExtension) {
        List<String> filteredFiles = new ArrayList<>();

        try {
            String fullPath = FileManager.getCurrentDirectory() + File.separator + directoryName;
            File directory = new File(fullPath);

            if (directory.isDirectory()) {
                File[] files = directory.listFiles();

                if (files != null && files.length > 0) {
                    for (File file : files) {
                        if (file.isFile() && file.getName().endsWith(fileExtension)) {
                            filteredFiles.add(file.getName());
                        }
                    }

                    if (!filteredFiles.isEmpty()) {
                        System.out.println("Filtered files in " + directoryName + " with extension " + fileExtension + ":");
                        for (String filteredFile : filteredFiles) {
                            System.out.println(filteredFile);
                        }
                    } else {
                        System.out.println("No files match the filter criteria.");
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

        return filteredFiles;
    }
}
