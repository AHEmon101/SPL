public class HelpCommand {
    public static void displayHelp() {
        System.out.println("Available commands:");
        System.out.println("1. createFile <file_name>");
        System.out.println("2. createDirectory <directory_name>");
        System.out.println("3. deleteFile <file_name>");
        System.out.println("4. deleteDirectory <directory_name>");
        System.out.println("5. renameFile <old_file_name> <new_file_name>");
        System.out.println("6. moveFile <source_file> <destination_file>");
        System.out.println("7. copyFile <source_file> <destination_file>");
        System.out.println("8. listContents <directory>");
        System.out.println("9. searchFiles <directory> <query>");
        System.out.println("10. viewFile <file_name>");
        System.out.println("11. editFile <file_name>");
        System.out.println("12. sortFiles <directory>");
        System.out.println("13. filterFiles <directory> <file_extension>");
        System.out.println("14. help");
    }
}
