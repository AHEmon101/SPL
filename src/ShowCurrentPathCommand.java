public class ShowCurrentPathCommand {
    public static void showCurrentPath() {
        String currentPath = FileManager.getCurrentDirectory();
        System.out.println("Current Working Directory: " + currentPath);
    }
}
