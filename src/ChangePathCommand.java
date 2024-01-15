import java.io.File;
import java.util.Scanner;

public class ChangePathCommand {
    public static void changePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the new path: ");
        String newPath = scanner.nextLine().trim();

        File newDirectory = new File(newPath);

        if (newDirectory.isDirectory() && newDirectory.exists()) {
            FileManager.setCurrentDirectory(newPath);
            System.out.println("Current working directory changed to: " + newPath);
        } else {
            System.out.println("The specified path is not a valid directory.");
        }
    }
}
