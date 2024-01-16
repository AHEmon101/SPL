import java.io.File;

public class FileTree {
    private String rootPath;

    public FileTree() {
        this.rootPath = new File("").getAbsolutePath();
    }

    private void displayTree(File directory, int indent) {
        if (directory.isDirectory()) {
            System.out.println("|   ".repeat(indent) + "|-- " + directory.getName());
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    displayTree(file, indent + 1);
                }
            }
        }
    }

    public void showTree() {
        File rootDirectory = new File(rootPath);
        System.out.println(rootDirectory.getName());
        displayTree(rootDirectory, 0);
    }
}