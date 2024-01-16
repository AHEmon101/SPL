import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class SortCommand {
    public static void sortFiles(String directoryName) {
        try {
            String fullPath = FileManager.getCurrentDirectory() + File.separator + directoryName;
            File directory = new File(fullPath);

            if (directory.isDirectory()) {
                File[] files = directory.listFiles();

                if (files != null && files.length > 0) {
                    Arrays.sort(files, Comparator.comparing(File::getName));
                    System.out.println("Sorted files in " + directoryName + ":");
                    for (File file : files) {
                        System.out.println(file.getName());
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
