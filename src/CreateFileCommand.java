import java.io.File;
import java.io.IOException;
import FileModify.FileModify;
public class CreateFileCommand {
    public static void createFile(String fileName) {
        try {
            String fullPath = FileManager.getCurrentDirectory() + File.separator + fileName;
            FileModify writer = new FileModify(fullPath);
            writer.close();
            System.out.println("File created: " + fullPath);
        } catch (IOException e) {
            System.out.println("Error creating the file: " + e.getMessage());
        }
    }
}
