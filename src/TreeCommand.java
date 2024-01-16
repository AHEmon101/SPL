import java.io.File;

public class TreeCommand {
    public static void showTree(String path, String prefix) {
        File directory = new File(path);

        System.out.println(prefix + directory.getName());

        File[] files = directory.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String childPrefix = (i == files.length - 1) ? prefix + "    " : prefix + "│   ";
                showTree(files[i].getPath(), childPrefix);
            }
        }
    }
}