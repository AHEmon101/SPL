
import java.util.List;
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
            //1
            case "showcurrentpath":
                ShowCurrentPathCommand.showCurrentPath();
                break;
            //2
            case "changepath":
                ChangePathCommand.changePath();
                break;
            //3
            case "createfile":
                CreateFileCommand.createFile(argument);
                break;
            //4
            case "createdirectory":
                CreateDirectoryCommand.createDirectory(argument);
                break;
                //5
            case "deletefile":
                DeleteCommand.deleteFile(argument);
                break;
                //6
            case "deletedirectory":
                DeleteCommand.deleteDirectory(argument);
                break;
            //7
            case "renamefile":
                String[] parts = argument.split(" ", 2);
                if (parts.length == 2) {
                    RenameFileCommand.renameFile(parts[0], parts[1]);
                } else {
                    System.out.println("Invalid command. Usage: renamefile <old_file_name> <new_file_name>");
                }
                break;
            //8
            case "movefile":
                String[] moveParts = argument.split(" ", 2);
                if (moveParts.length == 2) {
                    MoveFileCommand.moveFile(moveParts[0], moveParts[1]);
                } else {
                    System.out.println("Invalid command. Usage: movefile <source_file> <destination_file>");
                }
                break;
            //9
            case "copyfile":
                String[] copyParts = argument.split(" ", 2);
                if (copyParts.length == 2) {
                    CopyCommand.copyFile(copyParts[0], copyParts[1]);
                } else {
                    System.out.println("Invalid command. Usage: copyfile <source_file> <destination_file>");
                }
                break;
            //10
            case "listcontents":
                ListContentsCommand.listContents(argument);
                break;
            //11
            case "searchfiles":
                String[] searchParts = argument.split(" ", 2);
                String query = searchParts.length > 1 ? searchParts[1] : "";
                List<String> foundFiles = SearchCommand.searchFiles(searchParts[0], query);
                System.out.println("Found files:");
                for (String foundFile : foundFiles) {
                    System.out.println(foundFile);
                }
                break;
            //12
            case "viewfile":
                ViewFileCommand.viewFile(argument);
                break;
            //13
            case "editfile":
                EditFileCommand.editFile(argument);
                break;
            //14
            case "sortfiles":
                SortCommand.sortFiles(argument);
                break;
            //15
            case "filterfiles":
                String[] filterParts = argument.split(" ", 2);
                if (filterParts.length == 2) {
                    List<String> filteredFiles = FilterCommand.filterFiles(filterParts[0], filterParts[1]);
                    System.out.println("Filtered files:");
                    for (String filteredFile : filteredFiles) {
                        System.out.println(filteredFile);
                    }
                } else {
                    System.out.println("Invalid command. Usage: filterfiles <directory> <file_extension>");
                }
                break;
            //16


            case "help":
                displayHelp();
                break;
            //17
                case "tree":
                TreeCommand.showTree(currentDirectory, "");
                break;
            default:
                System.out.println("Invalid command. Enter 'help' to see available commands.");
        }
    }

    private static void displayHelp() {
        System.out.println("---------Available commands----------");
        System.out.println("1. showcurrentpath - Show current working directory");
        System.out.println("2. changepath <path> - Change current working directory to absolute path");
        System.out.println("3. createfile <file_name>");
        System.out.println("4. createdirectory <directory_name>");
        System.out.println("5. deletefile <file_name>");
        System.out.println("6. deletedirectory <directory_name>");
        System.out.println("7. searchfiles <directory> [query]");
        System.out.println("8. renamefile <old_file_name> <new_file_name>");
        System.out.println("9. movefile <source_file> <destination_file>");
        System.out.println("10. copyfile <source_file> <destination_file>");
        System.out.println("11. listcontents <directory>");
        System.out.println("12. searchfiles <directory> [query]");
        System.out.println("13. viewfile <file_name>");
        System.out.println("14. editfile <file_name>");
        System.out.println("15. sortfiles <directory>");
        System.out.println("16. filterfiles <directory> <file_extension>");
        System.out.println("17. help");
        System.out.println("18. tree");
        System.out.println("Type 'exit' to exit the File Manager.");
    }
}
