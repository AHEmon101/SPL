import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ViewFileCommand {
    public static void viewFile(String fileName) {
        try {
            String fullPath = FileManager.getCurrentDirectory() + File.separator + fileName;
            FileReader fileReader = new FileReader(fullPath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException | SecurityException e) {
            System.out.println("Error viewing the file: " + e.getMessage());
        }
    }
}
