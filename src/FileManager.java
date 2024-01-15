
import java.util.Scanner;


public class FileManager {
    private static String currentDirectory = ".";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the File Manager!");
        displayHelp();

        while (true) {
            System.out.print("Enter a command (or 'help' for available commands): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            String[] commandParts = input.split(" ", 2);
            String action = commandParts[0].toLowerCase();
            String argument = commandParts.length > 1 ? commandParts[1] : "";

            executeFullCommand(action, argument);
        }
    }

    public static void setCurrentDirectory(String directory) {
        currentDirectory = directory;
    }

    public static String getCurrentDirectory() {
        return currentDirectory;
    }

    private static void executeFullCommand(String action, String argument) {
        switch (action) {
            case "createfile":
                CreateFileCommand.createFile(argument);
                break;

            case "deletefile":
                DeleteCommand.deleteFile(argument);
                break;
            case "deletedirectory":
                DeleteCommand.deleteDirectory(argument);
                break;
            case "renamefile":
                String[] parts = argument.split(" ", 2);
                if (parts.length == 2) {
                    RenameFileCommand.renameFile(parts[0], parts[1]);
                } else {
                    System.out.println("Invalid command. Usage: renamefile <old_file_name> <new_file_name>");
                }
                break;
            case "copyfile":
                String[] copyParts = argument.split(" ", 2);
                if (copyParts.length == 2) {
                    CopyCommand.copyFile(copyParts[0], copyParts[1]);
                } else {
                    System.out.println("Invalid command. Usage: copyfile <source_file> <destination_file>");
                }
                break;

            case "showcurrentpath":
                ShowCurrentPathCommand.showCurrentPath();
                break;
            case "help":
                displayHelp();
                break;
            case "changepath":
                ChangePathCommand.changePath();
                break;
            default:
                System.out.println("Invalid command. Enter 'help' to see available commands.");
        }
    }

    private static void displayHelp() {
        System.out.println("Available commands:");
        System.out.println("createfile <file_name>");
        System.out.println("deletefile <file_name>");
        System.out.println("renamefile <old_file_name> <new_file_name>");
        System.out.println("showcurrentpath - Show current working directory");
        System.out.println("changepath <path> - Change current working directory to absolute path");
        System.out.println("help");
        System.out.println("Type 'exit' to exit the File Manager.");
    }
}
